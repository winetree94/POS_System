import React from "react";
import {Row, Col} from "reactstrap";

export default class SaleMain extends React.Component {
	
	getData = () => {
		console.log(this.data);
	
	}
	
	render() {
		return (
			<Row>
				<Col>{JSON.stringify(this.state)}</Col>
			</Row>
		);
	}
}