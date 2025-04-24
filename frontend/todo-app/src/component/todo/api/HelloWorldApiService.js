import { apiClient } from "./ApiClient";

// export function retrieveHelloWorldBean() {
//     // axios
//     //     .get("http://localhost:8080/hello-world")
//     //     .then((response) => successfulResponse(response))
//     //     .catch((error) => errorResponse(error))
//     //     .finally(() => console.log("정리"));

//     return axios.get("http://localhost:8080/hello-world-bean");
// }

export const retrieveHelloWorldBean = () => apiClient.get("/hello-world-bean");

export const retrieveHelloWorldPathVariable = (name) =>
    apiClient.get(`/hello-world/path-variable/${name}`, {
        // headers: {
        //     Authorization: token,
        // },
    });
