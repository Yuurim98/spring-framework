import { createContext, useContext, useState } from "react";
import { apiClient } from "../api/ApiClient";
import {
    executeBasicAuthenticationService,
    executeJWTAuthenticationService,
} from "../api/Authentication";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
    const [isAuthenticated, setAuthenticated] = useState(false);

    const [username, setUsername] = useState(null);

    const [token, setToken] = useState(null);

    // async function login(username, password) {
    //     const baToken = "Basic " + window.btoa(username + ":" + password);

    //     try {
    //         const response = await executeBasicAuthenticationService();

    //         if (response.status == 200) {
    //             setAuthenticated(true);
    //             setUsername(username);
    //             setToken(baToken);
    //             apiClient.interceptors.request.use((config) => {
    //                 console.log("토큰 추가");
    //                 config.headers.Authorization = baToken;
    //                 return config;
    //             });

    //             return true;
    //         } else {
    //             logout();

    //             return false;
    //         }
    //     } catch {
    //         logout();
    //         return false;
    //     }
    // }

    async function login(username, password) {
        try {
            const response = await executeJWTAuthenticationService(
                username,
                password
            );

            if (response.status == 200) {
                const jwtToken = "Bearer " + response.data.token;
                setAuthenticated(true);
                setUsername(username);
                setToken(jwtToken);
                apiClient.interceptors.request.use((config) => {
                    console.log("토큰 추가");
                    config.headers.Authorization = jwtToken;
                    return config;
                });

                return true;
            } else {
                logout();

                return false;
            }
        } catch {
            logout();
            return false;
        }
    }

    function logout() {
        setAuthenticated(false);
        setUsername(null);
        setToken(null);
    }

    return (
        <AuthContext.Provider
            value={{ isAuthenticated, login, logout, username, token }}
        >
            {children}
        </AuthContext.Provider>
    );
}
