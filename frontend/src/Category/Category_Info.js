import React, {Component} from 'react';

class CategoryInfo extends Component {
    render() {


        const {CATEG_NAME} = this.props.info;

        return (
            <tr onClick={()=>{this.props.onClick(this.props.info)}}>
            <th>{CATEG_NAME}</th>
             </tr>
        );
    }
}

export default CategoryInfo;