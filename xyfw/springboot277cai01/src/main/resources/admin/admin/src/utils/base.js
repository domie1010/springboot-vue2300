const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot277cai01/",
            name: "springboot277cai01",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot277cai01/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园朋友圈"
        } 
    }
}
export default base
