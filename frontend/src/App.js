import React from 'react';
import SideBar from './comm/SideBar.js';
import Header from './comm/Header.js';
import {
	Row,
	Col
} from 'reactstrap';
import Axios from 'axios';
import { getOrder } from './js/PosData.js';
import SaleMain from './sale/SaleMain.js';

export default class App extends React.Component {
	
	render() {
		
		return (
			<div>
				<Header></Header>
				<Row>
					<Col md={2}>
						<SideBar></SideBar>
					</Col>
					<Col>
						<SaleMain></SaleMain>
					</Col>
				</Row>
			</div>
		)
	}
}
