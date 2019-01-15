import React, { Component } from 'react'
import '../App.css';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';
import Modal from 'react-responsive-modal';
import TaskUserRegister from './TaskUserRegister'

class App extends Component {
    constructor() {
        super()
        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleChangeDescription = this.handleChangeDescription.bind(this);
        this.handleChangeResponsible = this.handleChangeResponsible.bind(this);
        this.handleChangeEstimatedTime = this.handleChangeEstimatedTime.bind(this);
        this.handleChangeSpentTime = this.handleChangeSpentTime.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

        this.state = {
            titleValue: '',
            descriptionValue: '',
            responsibleValue: '',
            estimatedTimeValue: '',
            spentTimeValue: '',
            open: false,
            tableData: [],
            formData: []
        };
    }

    handleChangeTitle(evt) {
        this.setState({
            titleValue: evt.target.value
        });
    }

    handleChangeDescription(evt) {
        this.setState({
            descriptionValue: evt.target.value
        });
    }

    handleChangeResponsible(evt) {
        this.setState({
            responsibleValue: evt.target.value
        });
    }

    handleChangeEstimatedTime(evt) {
        this.setState({
            estimatedTimeValue: evt.target.value
        });
    }

    handleChangeSpentTime(evt) {
        this.setState({
            spentTimeValue: evt.target.value
        });
    }

    priceFormatter(cell, row) {
        return '<i class="glyphicon glyphicon-usd"></i> ' + cell;
    }

    componentDidMount() {
        //Load da tela.
        this.setState({
            tableData: [{
                id: 1,
                task: "Tarefa 1",
                description: "Teste Tarefa 1.",
                user: "Junior",
                status: "Parado",
                timeEstimated: "01:00",
                timeSpent: "00:45",
                timeDetour: "00:15",
                dateCreation: "07/11/2018 16:10",
            }, {
                id: 2,
                task: "Tarefa 2",
                description: "Teste Tarefa 2.",
                user: "Jose",
                status: "Em Andamento",
                timeEstimated: "10:00",
                timeSpent: "40:00",
                timeDetour: "30:00",
                dateCreation: "10/11/2018 17:00",
            },
            ]
        });
    }

    state = {
        open: false,
    };

    onOpenModal = () => {
        this.setState({ open: true });
    };

    onCloseModal = () => {
        this.setState({ open: false });
    };

    componentWillMount() {
        this.setState({
            formData: [{
                title: this.state.titleValue,
                description: this.state.descriptionValue,
                user: this.state.responsibleValue,
                status: "Em Andamento",
                timeEstimated: this.state.timeEstimated,
                timeSpent: this.state.timeSpent,
            }]
        })
    }

    handleSubmit(event) {
        alert('submited!!' + this.state.formData);
        event.preventDefault();
    }

    render() {
        const { open } = this.state;
        return (
            <div id="divMain">
                <div id="divInputsForm">
                    <form onSubmit={this.handleSubmit}>
                        <h2>Gerenciador de Tarefas</h2>
                        <hr />
                        <div className="form-group">
                            <label id='lblTask'>Tarefa</label>
                            <input required type="text" className="form-control" placeholder='Tarefa' value={this.state.titleValue} onChange={evt => this.handleChangeTitle(evt)} />
                            <small id="taskHelp" className="form-text text-muted">Preencha uma tarefa.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label id='lblDescricao'>Descrição</label>
                            <input required type="text" className="form-control" placeholder='Descrição' value={this.state.descriptionValue} onChange={evt => this.handleChangeDescription(evt)} />
                            <small id="taskHelp" className="form-text text-muted">Preencha uma descrição para tarefa.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label for="sel1">Status</label>
                            <select class="form-control" id="selStatus">
                                <option>Fila de espera</option>
                                <option>Em andamento</option>
                                <option>Parado</option>
                                <option>Concluido</option>
                            </select>
                            <small id="taskHelp" className="form-text text-muted">Selecione seu sexo.</small>
                        </div>

                        <div className="form-group">
                            <label id='lblDescricao'>Responsável</label>
                            <input required type="text" className="form-control" placeholder='Responsável' value={this.state.responsibleValue} onChange={evt => this.handleChangeResponsible(evt)} />
                            <small id="taskHelp" className="form-text text-muted">Preencha um responsável pela tarefa.</small>
                        </div>
                        <div className="form-group">
                            <label id='lblDescricao'>Tempo Estimado</label>
                            <input required type="time" className="form-control" placeholder='Tempo Estimado' value={this.state.estimatedTimeValue} onChange={evt => this.handleChangeEstimatedTime(evt)} />
                            <small id="taskHelp" className="form-text text-muted">Preencha um tempo estimado.</small>
                        </div>
                        <br />
                        <div className="form-group">
                            <label id='lblDescricao'>Tempo Gasto</label>
                            <input required type="time" className="form-control" placeholder='Tempo Gasto' value={this.state.spentTimeValue} onChange={evt => this.handleChangeSpentTime(evt)} />
                            <small id="taskHelp" className="form-text text-muted">Preencha o tempo gasto.</small>
                        </div>
                        <div className='button__container'>
                            <button className='button btn-sm' value="Submit">Adicionar Tarefa</button>
                            <button className='button btn-sm' value="Submit">Editar Tarefa</button>
                            <button className='button btn-sm' value="Submit">Excluir Tarefa</button>
                            <button type="button" className="button btn-sm" onClick={this.onOpenModal}>Cadastrar usuários</button>
                        </div>
                    </form>
                </div>

                <div id="diButtonsForm" className='button__container'>

                </div>

                <div id="divGridForm">
                    <BootstrapTable data={this.state.tableData} striped={true} hover={true}>
                        <TableHeaderColumn dataField="id" isKey={true} dataAlign="center" dataSort={true}>ID</TableHeaderColumn>
                        <TableHeaderColumn dataField="task" dataSort={true}>Tarefa</TableHeaderColumn>
                        <TableHeaderColumn dataField="description" dataFormat={this.priceFormatter}>Descrição</TableHeaderColumn>
                        <TableHeaderColumn dataField="user" dataFormat={this.priceFormatter}>Responsável</TableHeaderColumn>
                        <TableHeaderColumn dataField="status" dataFormat={this.priceFormatter}>Status</TableHeaderColumn>
                        <TableHeaderColumn dataField="timeEstimated" dataSort={true}>Tempo Estimado</TableHeaderColumn>
                        <TableHeaderColumn dataField="timeDone" dataSort={true}>Tempo Gasto</TableHeaderColumn>
                        <TableHeaderColumn dataField="timeDetour" dataSort={true}>Desvio</TableHeaderColumn>
                        <TableHeaderColumn dataField="dateCreation" dataSort={true}>Data Criação</TableHeaderColumn>
                    </BootstrapTable>
                </div>

                <div id="divModalForm">
                    <Modal open={open} onClose={this.onCloseModal} center>
                        <TaskUserRegister></TaskUserRegister>
                    </Modal>
                </div>
            </div >
        )
    }
}
export default App