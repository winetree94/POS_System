import React, {Component} from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

class CashbookEdit extends Component {

    state = {
        modal: false,
        modal2: false,
        inputName : "입금",
        outputName : "출금",
        cash_deposit : '',
        outcome : ''
    };


    constructor(props) {
        super(props);


        this.toggle = this.toggle.bind(this);
        this.toggle2 = this.toggle2.bind(this);
    }





    toggle() {
        this.setState({
            modal: !this.state.modal,

        });
    }

    toggle2() {
        this.setState({
            modal2 : ! this.state.modal2,
        });
    }


    changeHandler = (e) => {
        this.setState({
            [e.target.name] : e.target.value
        });
    };

    submitHandler = (e) => {
        e.preventDefault();
        this.props.onCreate(this.state);
        this.setState({
            cash_deposit : '',
            outcome : '',
           modal : false,
            modal2 : false
        })
    };



    render() {
        return (
            <div className="content-box">
                <div className="row text-right">


            <div className="col">
                <Button color="danger" onClick={this.toggle}>{this.state.inputName}</Button>
                <Modal isOpen={this.state.modal} fade={false} toggle={this.toggle} className={this.props.className}>
                    <ModalHeader toggle={this.toggle}>현금 {this.state.inputName}액을 넣어주세요.</ModalHeader>
                    <form method="post" onSubmit={this.submitHandler}>
                        <ModalBody>
                            <div>
                                <input type="text" name='cash_deposit' placeholder="금액을 입력해주세요" onChange={this.changeHandler} value={this.state.cash_deposit} className="form-control" />
                            </div>
                        </ModalBody>
                        <ModalFooter>
                            <Button color="primary" type="submit"> 확인 </Button>{' '}
                            <Button color="secondary" onClick={this.toggle} >취소 </Button>
                        </ModalFooter>

                    </form>
                </Modal>
            </div>


                <div className="col text-left">
                    <Button color="primary" onClick={this.toggle2}>{this.state.outputName}</Button>
                    <Modal isOpen={this.state.modal2} fade={false} toggle={this.toggle2} className={this.props.className}>
                        <ModalHeader toggle={this.toggle2}>현금 {this.state.outputName}액을 넣어주세요.</ModalHeader>

                        <form onSubmit={this.submitHandler}>
                            <ModalBody>
                                <div>
                                    <input type="text" name="outcome"  value={this.state.outcome} placeholder="금액을 입력해주세요" onChange={this.changeHandler} className="form-control"/>
                                </div>
                            </ModalBody>
                            <ModalFooter>
                                <Button color="primary" > 확인 </Button>{' '}
                                <Button color="secondary" onClick={this.toggle2} >취소 </Button>
                            </ModalFooter>

                        </form>

                    </Modal>
                </div>




                </div>
            </div>
        );
    }
}

export default CashbookEdit;