import React from 'react';
import {TabContent, TabPane, Nav, NavItem, NavLink, Card, Button, CardTitle, CardText, Row, Col} from 'reactstrap';
import classnames from 'classnames';
import Axios from "axios";
import Comma from '../utility/common-utility';

class Table_MenuList extends React.Component {
	
	state = {
		category: [],
		activeTab: ''
	};
	
	constructor(props) {
		super(props);
	}
	
	render() {
		
		const categories = this.props.category.map(category => (
			<div key={category.CATEG_NAME}>
				<NavLink
					className={classnames({active: this.props.activeTab === category.CATEG_NAME})}
					onClick={() => {
						this.props.toggle(category.CATEG_NAME);
					}}
				>
					{category.CATEG_NAME}
				</NavLink>
			</div>
		));
		
		const menusItem = this.props.menus.map(category => (
			<Row key={category.menu_seq} onClick={()=>{this.props.onClick(category)}}>
				
				<table className={"table"}>
					<tbody>
					<tr>
						<td>{category.menu_name}</td>
						<td className={"text-right"}>{Comma(category.menu_price)} 원</td>
					</tr>
					</tbody>
				</table>
			
			</Row>
		));
		
		const menus = this.props.category.map(category => (
			<TabPane key={category.CATEG_NAME} tabId={category.CATEG_NAME}>
				<Row>
					<Col sm="12">
						{menusItem}
					</Col>
				</Row>
			</TabPane>
		));
		
		
		return (
			<div className={"content-box"} style={{height: "400px"}}>
				<Nav style={{overflow:"auto"}} tabs>
					{categories}
				</Nav>
				
				<TabContent activeTab={this.props.activeTab}>
					{menus}
				</TabContent>
			
			
			</div>
		)
	}
	
}

export default Table_MenuList;