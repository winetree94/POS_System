import React, {Fragment} from 'react';
import {Collapse, Button, CardBody, Card, UncontrolledCollapse} from 'reactstrap';

export default class SideBar extends React.Component {
	
	state = {
		collapse: {
			management: false,
			analyze: false
		}
	};
	
	static defaultProps = {
	
	};
	
	constructor(props) {
		super(props);
		console.log(this.props);
	}
	
	toggleMmanagement = () => {
		this.setState({collapse: {management : !this.state.collapse.management}});
		console.log(this.state);
	};
	
	toggleAnalyze = () => {
		this.setState({collapse: {analyze : !this.state.collapse.analyze}});
	};
	
	handleClick = (e) => {
		e.preventDefault();
	}
	
	render() {
		return (
			<div className="sidebar">
				<ul className="nav flex-column">
					<li className="nav-item">
						<a className="nav-link" href="/sale" onClick={this.handleClick}>판매</a>
					</li>
					<li className="nav-item">
						<a className="nav-link" href="#" id={"toggler"} onClick={this.toggleAnalyze}>분석</a>
						<Collapse isOpen={this.state.collapse.analyze}>
							<a className="nav-link" href="#" >메뉴 관리</a>
							<a className="nav-link" href="#" >테이블 관리</a>
							<a className="nav-link" href="#" >직원 관리</a>
							<a className="nav-link" href="#" >POS 관리</a>
						</Collapse>
					</li>
					<li className="nav-item">
						<a className="nav-link" href="#" onClick={this.toggleMmanagement}>관리</a>
						<Collapse isOpen={this.state.collapse.management}>
							<a className="nav-link" href="#" >메뉴 관리</a>
							<a className="nav-link" href="#" >테이블 관리</a>
							<a className="nav-link" href="#" >직원 관리</a>
							<a className="nav-link" href="#" >POS 관리</a>
						</Collapse>
					</li>
					<li className="nav-item">
						<a className="nav-link" href="#">판매 내역</a>
					</li>
					<li className="nav-item">
						<a className="nav-link" href="#">현금출납부</a>
					</li>
				</ul>
			</div>
		)
	}
}