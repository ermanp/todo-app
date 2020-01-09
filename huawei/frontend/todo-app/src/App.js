import React, {Component} from 'react';
import FirstComponent from './components/learning-examples/FirstComponent'
import SecondComponent from './components/learning-examples/SecondComponent'
import ThirdComponent from './components/learning-examples/ThirdComponent'
import CounterButton from './components/counter/Counter'
import Counter from './components/counter/Counter'
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



class LearningComponents extends Component{
  render(){
    return (
      <div className="LearningComponents">
        Hello world
        <FirstComponent > </FirstComponent>
        <SecondComponent > </SecondComponent>
        <ThirdComponent > </ThirdComponent>
      </div>
    );
  }

}







export default App;
