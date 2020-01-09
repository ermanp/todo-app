import axios from 'axios'

class UserDataService{

    createUser(user){

        console.log('createUser');
        console.log(user.username);
        console.log(user.password);
        return axios.post('http://localhost:8080/user/sign-up',user);
    }



}


export default new UserDataService