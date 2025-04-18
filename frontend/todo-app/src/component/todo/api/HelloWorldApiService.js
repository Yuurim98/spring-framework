import axios from "axios";

// export function retrieveHelloWorldBean() {
//     // axios
//     //     .get("http://localhost:8080/hello-world")
//     //     .then((response) => successfulResponse(response))
//     //     .catch((error) => errorResponse(error))
//     //     .finally(() => console.log("정리"));

//     return axios.get("http://localhost:8080/hello-world-bean");
// }

export const retrieveHelloWorldBean = () =>
    axios.get("http://localhost:8080/hello-world-bean");
