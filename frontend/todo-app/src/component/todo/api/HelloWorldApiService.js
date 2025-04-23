import axios from "axios";

// export function retrieveHelloWorldBean() {
//     // axios
//     //     .get("http://localhost:8080/hello-world")
//     //     .then((response) => successfulResponse(response))
//     //     .catch((error) => errorResponse(error))
//     //     .finally(() => console.log("정리"));

//     return axios.get("http://localhost:8080/hello-world-bean");
// }

const api = axios.create({
    baseURL: "http://localhost:8080",
});

export const retrieveHelloWorldBean = () => api.get("/hello-world-bean");

export const retrieveHelloWorldPathVariable = (name) =>
    api.get(`/hello-world/path-variable/${name}`, {
        headers: {
            Authorization: "Basic dGVzdDp0ZXN0cHc=",
        },
    });

export const executeBasicAuthenticationService = (token) =>
    api.get(`/basicauth`, {
        headers: {
            Authorization: token,
        },
    });
