import axios from "axios";

const api = axios.create({
    baseURL: "http://localhost:8080",
});

export const retrieveAllTodosForUsernameApi = (username) =>
    api.get(`/users/${username}/todos`);

export const deleteTodoApi = (username, id) =>
    api.delete(`/users/${username}/todos/${id}`);

export const retrieveTodoApi = (username, id) =>
    api.get(`/users/${username}/todos/${id}`);

export const updateTodoApi = (username, id, todo) =>
    api.put(`/users/${username}/todos/${id}`, todo);
