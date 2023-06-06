import Cookies from 'js-cookie';

const TOKEN_KEY = 'token';

export function getToken() {
    return Cookies.get(TOKEN_KEY);
}

export function setToken(token:string) {
    Cookies.set(TOKEN_KEY,token);
}

export function removeToken() {
    Cookies.remove(TOKEN_KEY);
}