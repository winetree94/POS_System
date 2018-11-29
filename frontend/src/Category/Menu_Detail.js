import React, {Component} from 'react';

class MenuDetail extends Component {
    render() {
        const{menu_seq,menu_name, menu_price} = this.props.info;

        return (
            <tr>
                <th>{menu_name}</th>
                <th className={"text-right"}>{menu_price}</th>
                <th className={"text-right"}><input type="checkbox" /></th>
            </tr>
        );
    }
}

export default MenuDetail;