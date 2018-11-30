import React, {Component} from 'react';

class MenuDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isChecked: true,
        };
    }

    render() {
        const{menu_seq, menu_name, menu_price, categ_name} = this.props.info;



        return (
            <tr>
                <th>{menu_name}</th>
                <th className={"text-right"}>{menu_price}</th>
                <label>
                <th className={"text-right"}><input type="checkbox" checked={this.state.isChecked}  /></th>
                </label>
            </tr>
        );
    }
}

export default MenuDetail;