import React from 'react';
import {Col, Row, Button, Card, CardBody, CardImg, CardSubtitle, CardText, CardTitle} from "reactstrap";
import Sale_TableItem from "./Sale_TableItem";

class Sale_TableList extends React.Component {
	render() {
		
		const {tableList} = this.props;
		const lists = tableList.map(tableItem => (
			<Sale_TableItem
				key={tableItem.table_seq}
				tableItem={tableItem}
			/>
		));
		
		return (
			<div className={"content-box"}>
				<Row>
					{lists}
				</Row>
			</div>
		)
	}
}

export default Sale_TableList;