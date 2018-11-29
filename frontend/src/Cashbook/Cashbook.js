import React from "react";
import Cashbook_List from "./Cashbook_List";
import Axios from "axios";
import CashbookEdit from "./Cashbook_Edit";


export default class Cashbook extends React.Component {

    state = {
        data : []

    };

    constructor (props){super(props);
   }

    componentDidMount = () => {

        setInterval(()=>{

        Axios.get('/api/cashbook').then((response)=>{
            this.setState({
                data : response.data
            })
        });
		console.log("render");

        }, 3000);
    };

    // handlerCreate = (info) => {
    //     const {data} = this.state;
    //     this.setState(
    //         {
    //
    //         }
    //     );
    // }


	
	render() {
	    const style = {
            border: '1px solid black',
            padding: '8px',
            margin: '8px',

        }

		return (
			<div className={"container content"}>
				<h1 className={"content-header-1"}>현금출납부</h1>


                <div className="row">
                    <div className="col" >
				<Cashbook_List data={this.state.data} />
                    </div>
                        <div className="col" >
                            <CashbookEdit/>
                        </div>
                </div>

			</div>








		);
	}
}