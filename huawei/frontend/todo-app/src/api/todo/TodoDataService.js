import axios from 'axios'
import {API_URL} from '../../Constants'
import {JPA_API_URL} from '../../Constants'

class TodoDataService{
    retrieveAlltodos(name){
        return axios.get(`${API_URL}/users/${name}/todos`);
       // console.log('executed service')

    }

    deleteTodo(name, id){
        return axios.delete(`${API_URL}/users/${name}/todos/${id}`);
        
    }

    updateTodo(name, id, todo){
        return axios.put(`${API_URL}/users/${name}/todos/${id}`, todo);
        
    }

    retrieveTodo(name, id){
        return axios.get(`${API_URL}/users/${name}/todos/${id}`);
        
    }

    createTodo(name, todo){
        console.log('### create todo');
        return axios.post(`${API_URL}/users/${name}/todos`, todo);
        
    }

    changeTodoStatus(name,id){
        console.log('change todo status');
        return axios.put(`${API_URL}/users/${name}/todos/change-status/${id}`, id)
    }

}

export default new TodoDataService()