import React, {Component} from 'react';
import CategoryInfo from "./Category_Info";


class CategoryList extends Component {
    render() {
        const {data, onClick} = this.props;

        const list = data.map(
            info => (
              <CategoryInfo key={info.CATEG_NAME} info={info} onClick={onClick}/>
            )
        );

        return (
            <div className="content-box" style={{overflow:"auto"}}>

                <table className={"table"}>
                    <thead>
                    <tr>
                        <th>카테고리명</th>
                    </tr>
                    </thead>
                    <tbody>
                    {list}
                    </tbody>
                </table>

            </div>
        );
    }
}

export default CategoryList;