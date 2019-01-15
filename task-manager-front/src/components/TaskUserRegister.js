import React, { Component } from 'react'
import '../App.css';


class App extends Component {
    constructor() {
        super()
        // this.handleChangeTitle = this.handleChangeTitle.bind(this);
        // this.handleChangeDescription = this.handleChangeDescription.bind(this);
        // this.handleChangeResponsible = this.handleChangeResponsible.bind(this);

        this.state = {
            userNameValue: '',
            passwordValue: '',
            emailValue: '',
            formData: []
        };
    }

    handleChangeName(evt) {
        this.setState({
            titleValue: evt.target.value
        });
    }

    handleChangePassword(evt) {
        this.setState({
            descriptionValue: evt.target.value
        });
    }

    handleChangeEmail(evt) {
        this.setState({
            responsibleValue: evt.target.value
        });
    }



    render() {
        return (
            <div >
                <div>
                    <form>
                        <h2>Cadastro de Usuários</h2>
                        <hr />
                        <h5>Informações de login</h5>
                        <div className="form-group">
                            <label id='lblTask'>Login</label>
                            <input type="text" className="form-control" placeholder='Nome' />
                            <small id="taskHelp" className="form-text text-muted">Preencha um login para o usuário.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label id='lblDescricao'>Senha</label>
                            <input type="text" className="form-control" placeholder='Senha' />
                            <small id="taskHelp" className="form-text text-muted">Defina uma senha para usuário.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label id='lblDescricao'>Confirmação da senha</label>
                            <input type="text" className="form-control" placeholder='Confirmação da senha' />
                            <small id="taskHelp" className="form-text text-muted">Digite sua senha novamente para confirmação.</small>
                        </div>
                        <br />
                        <h5>Informações pessoais</h5>
                        <div className="form-group">
                            <label id='lblDescricao'>Nome</label>
                            <input type="text" className="form-control" placeholder='Nome' />
                            <small id="taskHelp" className="form-text text-muted">Digite seu nome.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label id='lblDescricao'>Data de nascimento</label>
                            <input type="Data" className="form-control" placeholder='Nome' />
                            <small id="taskHelp" className="form-text text-muted">Digite seu nome.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label for="sel1">Sexo</label>
                            <select class="form-control" id="selGender">
                                <option>Masculino</option>
                                <option>Feminino</option>
                            </select>
                            <small id="taskHelp" className="form-text text-muted">Selecione seu sexo.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label id='lblDescricao'>Email</label>
                            <input type="Data" className="form-control" placeholder='Nome' />
                            <small id="taskHelp" className="form-text text-muted">Digite seu email.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label id='lblDescricao'>Confirmação do e-mail</label>
                            <input type="text" className="form-control" placeholder='Confirmação da senha' />
                            <small id="taskHelp" className="form-text text-muted">Digite seu email novamente para confirmação.</small>
                        </div>
                        <br />
                        <div className='button__container'>
                            <button className='button btn-sm' onClick={this.handleAddButton}>Adicionar</button>
                            <button className='button btn-sm' onClick={this.handleEditButton}>Editar</button>
                            <button className='button btn-sm' onClick={this.handleDeleteButton}>Excluir</button>
                        </div>
                    </form>
                </div>
            </div >
        )
    }
}

export default App
