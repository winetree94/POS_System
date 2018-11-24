import React from "react";
import {Row, Col} from "reactstrap";
import Axios from "axios";

export default class SaleMain extends React.Component {
	
	data = {};
	
	state = {
		value: []
	};
	
	componentDidMount() {
		Axios.get("/pos/1/order").then(response => {
			this.data = response.data;
			this.setState({
				value:response.data
			})
		});
	}
	
	getData = () => {
		console.log(this.data);
	
	}
	
	render() {
		return (
			<Row>
				<Col>d
					<input type="button" onClick={this.getData} value={"click"}/>
				</Col>
				<Col>d</Col>
				<Col>d</Col>
			</Row>
		);
	}
}