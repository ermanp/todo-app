import React, { Component } from 'react'
import AuthenticationService from './AuthenticationService.js'
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom'
import TodoDataService from '../../api/todo/TodoDataService.js'
import { withRouter } from 'react-router';

class HeaderComponent extends Component {
    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        console.log(isUserLoggedIn);
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><a href="#" onClick={this.handleClick} className="navbar-brand">ToDo</a></div>
                    <ul className="navbar-nav">
                        {/* {isUserLoggedIn && <li ><Link className="nav-link" to="/welcome/todo">Home</Link></li>} */}
                        {/* {isUserLoggedIn && <li ><Link className="nav-link" to="/todos">Todos</Link></li>} */}
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isUserLoggedIn && <li ><Link className="nav-link" to="/login">Login</Link></li>}
                        {isUserLoggedIn && <li ><Link className="nav-link" to="/logout" onClick={AuthenticationService.logout}>Logout</Link></li>}
                    </ul>
                    
                </nav>
            </header>

        )
    }

    handleClick = (e) => {
        e.preventDefault();
        let username = AuthenticationService.getLoggedInUserName()
        console.log('The link was clicked by ' + username);
      };
}

export default withRouter(HeaderComponent);