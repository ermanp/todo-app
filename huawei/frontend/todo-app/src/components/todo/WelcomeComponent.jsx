import React, { Component } from 'react'
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom'
import CommonService from '../../api/todo/CommonService.js'


class WelcomeComponent extends Component {
    constructor(props){
        super(props)
        this.retrieveWelcomeMessage = this.retrieveWelcomeMessage.bind(this)
        this.state = {
            welcomeMessage : ''
        }
        this.handleSuccessfulResponse = this.handleSuccessfulResponse.bind(this)
        this.handleError = this.handleError.bind(this)

    }
    render() {
        return (
            <>
            <h1>Welcome!</h1>
            <div className="container">
                Click here to get a customized welcome message
                <button onClick={this.retrieveWelcomeMessage} className="btn btn-success">Get Welcome Message</button>
            {/* <div>
            Welcome {this.props.match.params.name}. You can manage your todos <Link to="/todos">here.</Link>
            </div> */}
            </div>
            <div className="container">
                {this.state.welcomeMessage}
            </div>
            </>
        )
      
    }

    retrieveWelcomeMessage(){
        console.log('retrieve clicked')
    //    HelloWorldService.executeHelloWorldService()
    //    .then( response => this.handleSuccessfulResponse(response))

        CommonService.executeHelloWorldPathVariableService(this.props.match.params.name)
        .then( response => this.handleSuccessfulResponse(response))
        .catch(error => this.handleError(error))

        //.catch()
    }

    handleSuccessfulResponse(response){
        this.setState({welcomeMessage : response.data.message})
        
    }

    handleError(error){
        console.log(error.response)
        let errorMessage = '';

        if(error.message)
            errorMessage += errorMessage.message
        
        if(error.response && error.response.data){
            errorMessage += errorMessage.response.data.message
        }

        this.setState({welcomeMessage: errorMessage})
    }
}

export default WelcomeComponent