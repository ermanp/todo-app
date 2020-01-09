import React, {Component} from 'react'
import AuthenticationService from './AuthenticationService.js'

class LoginComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            username: '',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.handleChange = this.handleChange.bind(this);
        this.loginClicked = this.loginClicked.bind(this);
        this.userRegister = this.userRegister.bind(this);

    }

    handleChange(event) {
        // console.log(this.state);
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        )
    }


    userRegister(){
        this.props.history.push('/register')

    }

    loginClicked() {
               

        AuthenticationService.executeJwtAuthenticationService(this.state.username, this.state.password)
            .then(
                (response) => {
                    AuthenticationService.registerSuccessfulLoginForJwt(this.state.username, response.data.token)

                    this.props.history.push('/todos')
                }
            ).catch(
                () => {
                    this.setState({ showSuccessMessage: false })
                    this.setState({ hasLoginFailed: true })
                    console.log('Fail')
                }
            )


    }

    render() {
        return (
            <div>
                <h1>Login</h1>
                <div className="container">
                {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>*/}
                {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                {this.state.showSuccessMessage && <div>Login Successful</div>}
                User Name <input type="text" name="username" value={this.state.username} onChange={this.handleChange} />
                Password <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
                <br/><br/>
                <di>
                <button className="btn btn-success" onClick={this.userRegister}>Register</button>
                </di>
                </div>
            </div>
        )
    }
}

export default LoginComponent