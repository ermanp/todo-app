import axios from 'axios'

class CommonService{
    executeHelloWorldService(){
        return axios.get('http://localhost:8080/test');
       // console.log('executed service')

    }

    executeHelloWorldBeanService(){
        return axios.get('http://localhost:8080/test-bean');
    }

    executeHelloWorldPathVariableService(name) {

        return axios.get(`http://localhost:8080/test/path-variable/${name}`
            ,
            {
                headers: {
                    authorization: this.basicAuthHeader
                }
            }
        );
    }

}

export default new CommonService