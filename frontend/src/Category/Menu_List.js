import React, {Component} from 'react';
import common from "../utility/common-utility";
import MenuDetail from "./Menu_Detail";
import {Button, Modal, ModalHeader, ModalBody, ModalFooter} from 'reactstrap';


class MenuList extends Component {
    constructor(props) {
        super(props);

        this.toggle = this.toggle.bind(this);
        this.toggle2 = this.toggle2.bind(this);
        this.toggle3 = this.toggle3.bind(this);
    }

    state = {
        modal: false,
        modal2: false,
        modal3: false,
        menu_name : '',
        menu_price : '',
        menu_info : '',
        categ_name : ''
    };

    toggle() {
        this.setState({
            modal: !this.state.modal
        });
    }

    toggle2() {
        this.setState({
            modal2: !this.state.modal2
        });
    }

    toggle3() {
        this.setState({
            modal3: !this.state.modal3
        });
    }

    changeHandler = (e)=>{
        this.setState=({
            [e.target.name]: e.target.value
        });


    };


    createHandler = (e)=>{
        e.preventDefault();



    };







    render() {

            const {detail} = this.props;

        const list = detail.map(
            info =>(
                <MenuDetail info={info} key={detail.menu_seq} />
            )
        );





        return (
            <div className="content-box" style={{overflow:"auto"}}>

                <table className={"table"}>
                    <thead>
                    <tr>
                        <th >상품명</th>
                        <th className={"text-right"}>금액</th>
                        <th className={"text-right"}>체크박스</th>
                    </tr>
                    </thead>
                    <tbody>
                    {list}
                    </tbody>
                </table>



                <div className="row">
                    <div className="col text-right">
                        <Button color="primary" onClick={this.toggle}>추가</Button>
                        <Modal isOpen={this.state.modal} fade={false} toggle={this.toggle}
                               className={this.props.className}>
                            <ModalHeader toggle={this.toggle}>추가버튼작동</ModalHeader>
                            <form method="post" obSubmit={this.createHandler}>
                                <ModalBody>
                                    <div>
                                        <input name="menu_name"  placeholder="메뉴이름을 적어주세요." />
                                        <input placeholder="카테고리명을 적어주세요." />
                                        <input placeholder="설명을 적어주세요." />
                                        <input placeholder="가격을 정해주세요." />
                                    </div>
                                </ModalBody>
                                <ModalFooter>
                                    <Button color="primary" type="submit"> 확인 </Button>{' '}
                                    <Button color="secondary" onClick={this.toggle}>취소 </Button>
                                </ModalFooter>
                            </form>
                        </Modal>
                    </div>





                    <div className="col text-center">
                        <Button color="danger" onClick={this.toggle2}>수정</Button>
                        <Modal isOpen={this.state.modal2} fade={false} toggle={this.toggle2}
                               className={this.props.className}>
                            <ModalHeader toggle={this.toggle2}>수정버튼작동</ModalHeader>
                            <form method="post">
                                <ModalBody>
                                    <div>
                                        수정 하실겁니까
                                    </div>
                                </ModalBody>
                                <ModalFooter>
                                    <Button color="primary" type="submit"> 확인 </Button>{' '}
                                    <Button color="secondary" onClick={this.toggle2}>취소 </Button>
                                </ModalFooter>
                            </form>
                        </Modal>
                    </div>










                        <div className="col text-left">
                            <Button color="danger" onClick={this.toggle3}>삭제</Button>
                            <Modal isOpen={this.state.modal3} fade={false} toggle={this.toggle3}
                                   className={this.props.className}>
                                <ModalHeader toggle={this.toggle3}>삭제버튼작동</ModalHeader>
                                <form method="post">
                                    <ModalBody>
                                        <div>
                                     삭제 하실겁니까
                                        </div>
                                    </ModalBody>
                                    <ModalFooter>
                                        <Button color="primary" type="submit"> 확인 </Button>{' '}
                                        <Button color="secondary" onClick={this.toggle3}>취소 </Button>
                                    </ModalFooter>
                                </form>
                            </Modal>
                        </div>
            </div>





            </div>


        );
    }
}

export default MenuList;