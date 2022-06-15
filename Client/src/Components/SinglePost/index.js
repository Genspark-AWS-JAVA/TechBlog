import axios from "axios";
import React,{useEffect, useState} from "react";
import { useParams } from "react-router-dom";

const SinglePost = () => {
    const [data, setData] = useState()
    const article = useParams()
    console.log(article._id)
    useEffect(()=>{
        axios.get(`http://localhost:8080/articles/${article._id}`).then((res)=> {
            setData(res.data)
            console.log(data)
        })
    },[])

    return(
        <div>
            <h1>HELLO FROM THE SINGLE POST</h1>
        </div>
    )
}

export default SinglePost