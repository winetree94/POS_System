import React from 'react';
import CategoryList from "./Category_List";
import Menu_List from "./Menu_List";
import Axios from "axios";
import Loading from "../comm/Loading";
import qs from 'qs'
import InvoiceList from "../Invoice/InvoiceList";
import InvoiceDetail from "../Invoice/InvoiceDetail";
import {Spring, Trail} from "react-spring";

class Category extends React.Component {
	
	constructor(props) {
		super(props);
	}
	
	state = {
		data: [],
		categ_name: '',
		menu_list: [],
		detail: {},
		isLoad: false
	};
	
	componentDidMount = () => {
		this.interval = this.setIntervalAndExecution(this.dataUpdater, 3000);
	};
	
	setIntervalAndExecution = (callback, timeout) => {
		callback();
		return (setInterval(callback, timeout));
	};
	
	dataUpdater = () => {
		
		Axios.get('/api/menu').then((response) => {
			this.setState({
				data: response.data,
				isLoad: true
			})
		});
		
		if (this.state.categ_name != '') {
			Axios.get("/api/category/menulists/" + this.state.categ_name).then(response => {
				this.setState({
					menu_list: response.data
				});
			});
		}
		
	};
	
	clickHandler = (item) => {
		this.setState({
			categ_name: item.CATEG_NAME
		}, () => {
			this.dataUpdater();
		});
	};
	
	
	render() {
		
		
		const {isLoad} = this.state;
		
		if (!isLoad) {
			return <Loading msg="메뉴 목록을 로딩중입니다."></Loading>
			
			
		} else {
			return (
				<Spring
					from={{
						opacity: 0,
						transform: 'translateY(30px)'
					}}
					to={{
						opacity: 1,
						transform: 'translateY(0px)'
					}}>
					{props =>
						<div style={props}>
							
							<div className={"container content"}>
								
								<h1 className={"content-header-1"}>
									
									<Trail
										items={['메', '뉴', ' 관', '리']}
										from={{
											opacity: 0,
											transform: 'translate3d(0,40px,0)'
										}}
										to={{
											opacity: 1,
											transform: 'translate3d(0,0px,0)'
										}}
									>
										{item => props => (
											<span style={props}>{item}</span>
										)}
									</Trail>
								</h1>
								
								<div className={"row"}>
									<div className={"col"} style={{maxWidth: "300px"}}>
										<h4 className={"content-header-4"}>카테고리 목록</h4>
										<CategoryList data={this.state.data} onClick={this.clickHandler}/>
									</div>
									<div className={"col"}>
										<h4 className="content-header-4">메뉴 목록</h4>
										<Menu_List detail={this.state.menu_list} dataUpdater={this.dataUpdater}/>
									</div>
								</div>
							
							</div>
						</div>}
				</Spring>
			
			)
		}
		
	}
	
	componentWillUnmount() {
		clearInterval(this.interval);
	}
	
}

export default Category;
