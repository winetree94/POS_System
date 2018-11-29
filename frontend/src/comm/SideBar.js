import React, {Fragment} from 'react';
import { Link } from 'react-router-dom';
import { Dropdown, DropdownToggle, DropdownMenu, DropdownItem,Collapse } from 'reactstrap';

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
						<Link className="nav-link" exact={"true"} to="/sale">판매</Link>
					</li>
					{/*<li className="nav-item">
						<a className="nav-link" href="#" id={"toggler"} onClick={this.toggleAnalyze}>분석</a>
						<Collapse isOpen={this.state.collapse.analyze}>
							<a className="nav-link" href="#" >일 단위 매출</a>
							<a className="nav-link" href="#" >주 단위 매출</a>
							<a className="nav-link" href="#" >월 단위 매출</a>
							<a className="nav-link" href="#" >연 단위 매출</a>
						</Collapse>
					</li>*/}
					<li className="nav-item">
						<a className="nav-link" href="#" onClick={this.toggleMmanagement}>관리</a>
						<Collapse isOpen={this.state.collapse.management}>
							<Link className="nav-link" to="/category">메뉴 관리</Link>
							<Link className="nav-link" to="/table">테이블 관리</Link>
							{/*<a className="nav-link" href="#" >직원 관리</a>
							<a className="nav-link" href="#" >POS 관리</a>*/}
						</Collapse>
					</li>
					<li className="nav-item">
						<Link className="nav-link" to="/invoice">판매 내역</Link>
					</li>
					<li className="nav-item">
						<Link className="nav-link" to="/cashbook">현금출납부</Link>
					</li>
					
				</ul>
			</div>
		)
	}
}