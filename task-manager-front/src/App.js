import React, { Component } from 'react';
import './App.css';
import TaskManagerForm from './components/TaskManagerForm';

class App extends Component {
  render() {
    return (
      <div className="form__container">
        <TaskManagerForm></TaskManagerForm>
      </div>
    );
  }
}

export default App;
