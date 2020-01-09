import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import UserDataService from '../../api/todo/UserDataService.js'

class UserRegisterComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            username: '',
            password: ''
        }

        this.onSubmit = this.onSubmit.bind(this)

        
    }
    render() {
        let { username, password } = this.state

        return (<div>
            <h1>Todo </h1>
            <div className="container">
                <Formik
                    initialValues={{
                        username: username,
                        password: password
                    }}
                    
                    onSubmit={this.onSubmit}
                    enableReinitialize={true}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name="username" component="div"
                                    className="aler alert-warning" />
                                <ErrorMessage name="password" component="div"
                                    className="aler alert-warning" />
                                <fieldset className="form-group">
                                    <label>Username</label>
                                    <Field className="form-control"
                                        type="text"
                                        name="username" />

                                </fieldset>

                                <fieldset className="form-group">
                                    <label>Password</label>
                                    <Field className="form-control" type="password"
                                        name="password" />
                                </fieldset>
                                <button className="btn btn-success" type="submit">Save</button>
                            </Form>

                        )
                    }
                </Formik>

            </div>
        </div>)
    }



    onSubmit(values) {
        console.log(values);
        let user = {
            username: values.username,
            password: values.password
        }

        console.log('###' + user);
                
        UserDataService.createUser(user).then(() => { this.props.history.push('/login') })
    }

}

export default UserRegisterComponent