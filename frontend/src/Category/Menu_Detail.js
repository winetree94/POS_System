import React, {Component} from 'react';
import Comma from '../utility/common-utility';
import {Button, ButtonGroup, Popover, PopoverBody, PopoverHeader} from "reactstrap";
class MenuDetail extends Component {

    state = {
        menu_seq: '',
        categ_name:'',
        menu_name:'',
        menu_price:'',
        menu_info :'',
        popoverOpen: false,


    };

    constructor(props) {
        super(props);
    }

    toggle = () => {
        this.setState({
            popoverOpen: !this.state.popoverOpen
        });
    };

    toggleChange = (e) => {
        console.log("e타겟");
        this.setState({
            [e.target.name] : e.target.value,
            categ_name:this.props.info.categ_name,
            menu_name: this.props.info.menu_name,
            menu_price:this.props.info.menu_price,
            menu_info : this.props.info.menu_info

        }, () => {
                console.log("성공");
                console.log(this.state);
                const {onChange} = this.props;
                onChange(this.state);
                this.setState({
                    menu_seq: '',
                    categ_name:'',
                    menu_name: '',
                    menu_price:'',
                    menu_info : ''

                });
        });

    };

    componentDidMount = () => {
        this.setState({
            menu_seq: this.props.info.menu_seq,
            menu_name: this.props.info.menu_name,
            categ_name: this.props.info.categ_name,
            menu_price: this.props.info.price,
            menu_info : this.props.info.menu_info

        }, () => {
            console.log(this.state)
            console.log("메뉴인포")
            console.log(this.props.info.menu_info)
        })
    };


    render() {
        const {menu_seq, menu_name, menu_price, menu_info, categ_name} = this.props.info;


        return (
            <tr>
                <th id={"popover" + menu_seq} onClick={this.toggle}>{menu_name}</th>
                <Popover placement="right" isOpen={this.state.popoverOpen} target={"popover" + menu_seq} toggle={this.toggle}>
                    <PopoverBody>
                        <ButtonGroup>
                                <button className="btn btn-light" onClick={this.toggle}>{menu_info}</button>
                        </ButtonGroup>
                    </PopoverBody>
                </Popover>



                <th className={"text-right"}>{Comma(menu_price)} 원</th>

                <th className={"text-right"}><input name="menu_seq" type="radio"
                                                    defaultChecked={this.state.isChecked} value={menu_seq}
                                                    onChange={this.toggleChange.bind(this)}/></th>
            </tr>
        );
    }
}

export default MenuDetail;