import React, {Fragment} from 'react';
import {
	Collapse,
	Navbar,
	NavbarToggler,
	NavbarBrand,
	Nav,
	NavItem,
	NavLink
} from 'reactstrap';
import '../static/css/style.css';
import { Link } from 'react-router-dom';

export default class Header extends React.Component {
	
	constructor(props) {
		super(props);
		this.toggle = this.toggle.bind(this);
		this.state = {
			isOpen: false
		};
	}
	
	toggle() {
		this.setState({
			isOpen: !this.state.isOpen
		});
	}
	
	render() {
		console.log(this.props);
		return (
			<Fragment>
				<Navbar color="light" light expand="md">
					<div className={"container"} style={{maxWidth:"1280px"}}>
						<Link className="nav-link navbar-brand" to="/">POS</Link>
						<NavbarToggler onClick={this.toggle}/>
						<Collapse isOpen={this.state.isOpen} navbar>
							<Nav className="ml-auto" navbar>
								<NavItem>
									<NavLink href="#">{this.props.auth.service_id}</NavLink>
								</NavItem>
								<NavItem>
									<NavLink href="/account/logout">로그아웃</NavLink>
								</NavItem>
							</Nav>
						</Collapse>
					</div>
				</Navbar>
			</Fragment>
		)
	}
}