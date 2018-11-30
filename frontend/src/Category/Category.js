import React from 'react';
import CategoryList from "./Category_List";
import Menu_List from "./Menu_List";
import Axios from "axios";
import Loading from "../comm/Loading";
import qs from 'qs'

class Category extends React.Component {

    constructor (props){super(props);
    }

    state={
    	data : [],
		categ_name : '',
        menu_list : [],
        detail :{},
        isLoad: false
	};

    componentDidMount = () => {

        this.interval = setInterval(()=>{
            Axios.get('/api/menu').then((response)=>{
                this.setState({
                    data : response.data,
                    isLoad : true
                })
            });
        }, 1000);
    };

  	clickHandler = (item)=>{
  		this.setState({
                categ_name : item.CATEG_NAME
            },
            () => {


                this.interval2= setInterval(()=>  { Axios .get("/api/category/menulists/"+this.state.categ_name)
                    .then(response => {

                        this.setState({
                            menu_list: response.data

                        });



                    });},1000 );





            }
        );
    };



	render(){

        const {isLoad} = this.state;

		if(!isLoad){
            return <Loading msg="메뉴 목록을 로딩중입니다."></Loading>


		}else {
            return (
                <div className={"container content"}>

                    <h1 className={"content-header-1"}>
                        메뉴 관리
                    </h1>

                    <div className={"row"}>
                        <div className={"col content-box"}>
                            <CategoryList data={this.state.data} onClick={this.clickHandler} />
                        </div>
                        <div className={"col content-box"}>
                            <Menu_List detail={this.state.menu_list}/>
                        </div>
                    </div>


                </div>
            )
        }

	}

	componentWillUnmount(){
	    clearInterval(this.interval);
	    clearInterval(this.interval2);
    }

}

export default Category;
