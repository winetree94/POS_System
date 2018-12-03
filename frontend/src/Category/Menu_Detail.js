import React, {Component} from 'react';
import Comma from '../utility/common-utility';

class MenuDetail extends Component {

    state = {
        isChecked: false,
        menu_seq : ''
    };

    constructor(props) {
        super(props);
    }

    toggleChange = (e) => {

        this.setState({
            isChecked : !this.state.isChecked
        }, ()=>{
            console.log(this.state);
        });

        if(this.state.isChecked ==false){
            console.log("성공");
            const {onChange} = this.props;
            onChange(this.state.menu_seq);

        }else{
            console.log("망함");
        }

    };

    componentDidMount=()=> {
        this.setState({
            menu_seq : this.props.info.menu_seq
        }, ()=>{console.log(this.state)})
    };


    render() {
        const{menu_seq, menu_name, menu_price, categ_name} = this.props.info;



        return (
            <tr>
                <th>{menu_name}</th>
                <th className={"text-right"}>{Comma(menu_price)} 원</th>

                <th className={"text-right"}><input name="menu_seq" type="checkbox" defaultChecked={this.state.isChecked} value={menu_seq} onChange={this.toggleChange.bind(this)}  /></th>

            </tr>
        );
    }
}

export default MenuDetail;