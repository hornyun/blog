package com.hornyun.blog.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author hornyun
 */
@Data
@EqualsAndHashCode
public class UserDTO implements Serializable {
    private String username;
    private String email;

    private String token;
}
