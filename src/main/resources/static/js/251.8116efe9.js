"use strict";(self["webpackChunktwt_news_center"]=self["webpackChunktwt_news_center"]||[]).push([[251],{2779:function(t,s,e){e.r(s),e.d(s,{default:function(){return X}});var r=e(3396),n=e(9242);const a={class:"user-content"};function o(t,s,e,o,i,c){const l=(0,r.up)("navigationBar"),u=(0,r.up)("titleBar"),p=(0,r.up)("LoginPop"),g=(0,r.up)("router-view");return(0,r.wg)(),(0,r.iD)("div",a,[(0,r.Wm)(l),(0,r.Wm)(u),(0,r.wy)((0,r.Wm)(p,null,null,512),[[n.F8,this.$store.state.if_mask_layer]]),(0,r.Wm)(g)])}var i=e(7139),c=e.p+"img/Vector.ce0d7eda.svg",l=e.p+"img/TWT_News.0a10caca.svg";const u=t=>((0,r.dD)("data-v-b0672fde"),t=t(),(0,r.Cn)(),t),p={class:"navigation-bar"},g=u((()=>(0,r._)("div",{class:"heading-twt-text"},[(0,r._)("img",{src:c,class:"title-icon-2"}),(0,r._)("img",{src:l,class:"title-icon-3"})],-1))),d=["onClick"],_=["src"],m={class:"main-routers-text"};function v(t,s,e,n,a,o){return(0,r.wg)(),(0,r.iD)("div",p,[g,((0,r.wg)(!0),(0,r.iD)(r.HY,null,(0,r.Ko)(a.routers,(t=>((0,r.wg)(),(0,r.iD)("div",{key:t.router,class:(0,i.C_)(t.router=="/"+this.$route.path.split("/")[1]?"main-routers-yes":"main-routers-no"),onClick:s=>o.to(t.router)},[(0,r._)("img",{src:t.src,class:"router-icon"},null,8,_),(0,r._)("p",m,(0,i.zw)(t.name),1)],10,d)))),128))])}var w={name:"navigationBar",methods:{to(t){"/"==t?this.$router.push({path:t}):alert("暂不支持开放!")}},data(){return{if_navigation_show:1,routers:[{name:"全部",router:"/",src:e(782)},{name:"竞赛",router:"/Competition",src:e(9442)},{name:"社团公告",router:"/CommunityAnnouncement",src:e(5165)},{name:"通知",router:"/Notice",src:e(3166)},{name:"活动",router:"/Activities",src:e(9036)},{name:"新闻",router:"/News",src:e(5650)}]}}},f=e(89);const b=(0,f.Z)(w,[["render",v],["__scopeId","data-v-b0672fde"]]);var h=b,y=e.p+"img/search.47bb3cae.svg";const x={class:"title-bar"},C={class:"search-box"},k=(0,r._)("img",{src:y,class:"search-icon"},null,-1),D=["placeholder"],F=(0,r._)("div",{class:"twt-getting-box"},[(0,r._)("p",{class:"twt-getting-text"},"天外天 · 纳新进行中"),(0,r._)("p",{class:"twt-getting-hot"},"Hot")],-1),B={class:"twt-other-routers"},W=(0,r._)("p",{class:"twt-other-routers"},"关于我们",-1),Z={class:"twt-other-routers"},$={class:"login-button"};function N(t,s,e,a,o,i){return(0,r.wg)(),(0,r.iD)("div",x,[(0,r.wy)((0,r._)("div",C,[k,(0,r._)("input",{type:"text",class:"search-input",placeholder:o.some_text},null,8,D)],512),[[n.F8,0]]),F,(0,r.wy)((0,r._)("p",B,"工作室官网",512),[[n.F8,0]]),W,(0,r.wy)((0,r._)("p",Z,"投稿",512),[[n.F8,0]]),(0,r.wy)((0,r._)("button",$,"登录",512),[[n.F8,0]])])}var P={name:"titleBar",data(){return{some_text:"天津大学关于暑期实践的临时通知"}}};const A=(0,f.Z)(P,[["render",N]]);var H=A,I=e.p+"img/eye.37b74875.svg",L=e.p+"img/eye-off.94ba78eb.svg",T=e.p+"img/x.1a5ee3f7.svg";const z=t=>((0,r.dD)("data-v-4bddacfa"),t=t(),(0,r.Cn)(),t),K={class:"login-pop"},V=z((()=>(0,r._)("p",{class:"login-twt"},"登录天外天",-1))),Y=z((()=>(0,r._)("input",{type:"text",placeholder:"天外天账号/手机号/学号",class:"input-username"},null,-1))),j=z((()=>(0,r._)("p",{class:"relative-text-input"},"还没有账号？",-1))),q={class:"input-password-box"},E=["type"],G=z((()=>(0,r._)("p",{class:"relative-text-input"},"忘记密码？",-1))),J=z((()=>(0,r._)("button",{class:"login-button"},"登录",-1)));function M(t,s,e,a,o,i){return(0,r.wg)(),(0,r.iD)("div",K,[V,Y,j,(0,r._)("div",q,[(0,r._)("input",{type:o.if_password_eyes?"text":"password",placeholder:"密码",class:"input-password"},null,8,E),(0,r.wy)((0,r._)("img",{src:I,class:"password-icon",onClick:s[0]||(s[0]=t=>{o.if_password_eyes=0})},null,512),[[n.F8,o.if_password_eyes]]),(0,r.wy)((0,r._)("img",{src:L,class:"password-icon",onClick:s[1]||(s[1]=t=>{o.if_password_eyes=1})},null,512),[[n.F8,!o.if_password_eyes]])]),G,J,(0,r._)("img",{src:T,class:"login-pop-close",onClick:s[2]||(s[2]=t=>{this.$store.state.if_mask_layer=0})})])}var O={name:"loginPop",data(){return{if_password_eyes:0}}};const Q=(0,f.Z)(O,[["render",M],["__scopeId","data-v-4bddacfa"]]);var R=Q,S={name:"userContent",components:{navigationBar:h,titleBar:H,LoginPop:R}};const U=(0,f.Z)(S,[["render",o]]);var X=U},782:function(t,s,e){t.exports=e.p+"img/calendar.df9bc5a0.svg"},5650:function(t,s,e){t.exports=e.p+"img/file-minus.1d843eeb.svg"},5165:function(t,s,e){t.exports=e.p+"img/flag.ab7d1c61.svg"},9442:function(t,s,e){t.exports=e.p+"img/pen-tool.71549b7d.svg"},3166:function(t,s,e){t.exports=e.p+"img/radio.1d154269.svg"},9036:function(t,s,e){t.exports=e.p+"img/tag.7ab53057.svg"}}]);
//# sourceMappingURL=251.8116efe9.js.map