package com.hornyun.blog;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;

import java.sql.Types;
import java.util.Collections;

/**
 * @author hornyun
 * created on 2023 05 14
 */
public class MybatisPlusCodeGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String tableName = "t_user";
        String author = "hornyun";

        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/blog_hornyun?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456")
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath+ "/src/main/java/"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.hornyun") // 设置父包名
                            .moduleName("blog") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath+"/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName) // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .execute();

    }

}
