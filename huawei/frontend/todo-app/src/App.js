import React, {Component} from 'react';
import TodoApp from './components/todo/TodoApp'
import './bootstrap.css'


import logo from './logo.svg';
import './App.css';
import { render } from '@testing-library/react';

class App extends Component{
  render(){
  return (
    <div className="App">
      {/*<Counter/>*/}
      <TodoApp/>
    </div>
  );
}





}







export default App;
