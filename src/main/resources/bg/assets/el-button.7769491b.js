import{i as Se,f as X,u as o,g as ce,h as we,j as Ee,k as x,l as $e,m as Ie,q as R,s as Te,v as ue,x as le,y as Me,z as De,A as Ne,B as ze,N as K,C as W,D as Z,F as Ae,G as B,T as Le,H as U,I as de,J,K as fe,L as N,M as Fe,o as b,c as V,O as Oe,P as h,Q as P,w as T,R as Q,n as C,E as ee,S as _,U as ne,V as j,W as me,X as Pe,Y as ae,Z as pe,$ as Ve,a0 as oe,b as Y,a1 as q,a2 as Re,a3 as Ye,a as H,t as _e,a4 as Ue,a5 as Ge,a6 as He,a7 as Xe,a8 as We,a9 as re,aa as je,ab as Ke,ac as ie,ad as qe,ae as xe,af as Ze,ag as Je,ah as Qe,ai as eo,aj as oo}from "./index.eccd65ea.js";import{b as to,c as so,d as ve,e as no,f as lo,h as ao,U as ye}from "./user.06bfe2a8.js";const ro=(...e)=> a=>{e.forEach(t=>{Se(t)?t(a):t.value=a})},ge=Symbol("buttonGroupContextKey"),be=Symbol("dialogInjectionKey"),te=({from:e,replacement:a,scope:t,version:n,ref:i,type:l="API"}, c)=>{X(()=>o(c), s=>{},{immediate:!0})},io=(e, a, t)=>{let n={offsetX:0,offsetY:0};const i= s=>{const f=s.clientX,m=s.clientY,{offsetX:p,offsetY:y}=n,u=e.value.getBoundingClientRect(),v=u.left,E=u.top,z=u.width,A=u.height,r=document.documentElement.clientWidth,g=document.documentElement.clientHeight,k=-v+p,M=-E+y,L=r-v-z+p,F=g-E-A+y,S= d=>{const w=Math.min(Math.max(p+d.clientX-f,k),L),$=Math.min(Math.max(y+d.clientY-m,M),F);n={offsetX:w,offsetY:$},e.value.style.transform=`translate(${x(w)}, ${x($)})`},O=()=>{document.removeEventListener("mousemove",S),document.removeEventListener("mouseup",O)};document.addEventListener("mousemove",S),document.addEventListener("mouseup",O)},l=()=>{a.value&&e.value&&a.value.addEventListener("mousedown",i)},c=()=>{a.value&&e.value&&a.value.removeEventListener("mousedown",i)};ce(()=>{we(()=>{t.value?l():c()})}),Ee(()=>{c()})},co= e=>{$e(e)||Ie("[useLockscreen]","You need to pass a ref param to this function");const a=R("popup"),t=Te(()=>a.bm("parent","hidden"));if(!ue||le(document.body,t.value))return;let n=0,i=!1,l="0";const c=()=>{setTimeout(()=>{ze(document.body,t.value),i&&(document.body.style.width=l)},200)};X(e, s=>{if(!s){c();return}i=!le(document.body,t.value),i&&(l=document.body.style.width),n=to(a.namespace.value);const f=document.documentElement.clientHeight<document.body.scrollHeight,m=Me(document.body,"overflowY");n>0&&(f||m==="scroll")&&i&&(document.body.style.width=`calc(100% - ${n}px)`),De(document.body,t.value)}),Ne(()=>c())},he= e=>{if(!e)return{onClick:K,onMousedown:K,onMouseup:K};let a=!1,t=!1;return{onClick: c=>{a&&t&&e(c),a=t=!1},onMousedown: c=>{a=c.target===c.currentTarget},onMouseup: c=>{t=c.target===c.currentTarget}}},uo=["default","primary","success","warning","info","danger","text",""],fo=["button","submit","reset"],se=W({size:so,disabled:Boolean,type:{type:String,values:uo,default:""},icon:{type:Z},nativeType:{type:String,values:fo,default:"button"},loading:Boolean,loadingIcon:{type:Z,default:()=>Ae},plain:Boolean,text:Boolean,link:Boolean,bg:Boolean,autofocus:Boolean,round:Boolean,circle:Boolean,color:String,dark:Boolean,autoInsertSpace:{type:Boolean,default:void 0}}),mo={click: e=>e instanceof MouseEvent};function D(e, a=20){return e.mix("#141414",a).toString()}function po(e){const a=ve(),t=R("button");return B(()=>{let n={};const i=e.color;if(i){const l=new Le(i),c=e.dark?l.tint(20).toString():D(l,20);if(e.plain)n=t.cssVarBlock({"bg-color":e.dark?D(l,90):l.tint(90).toString(),"text-color":i,"border-color":e.dark?D(l,50):l.tint(50).toString(),"hover-text-color":`var(${t.cssVarName("color-white")})`,"hover-bg-color":i,"hover-border-color":i,"active-bg-color":c,"active-text-color":`var(${t.cssVarName("color-white")})`,"active-border-color":c}),a.value&&(n[t.cssVarBlockName("disabled-bg-color")]=e.dark?D(l,90):l.tint(90).toString(),n[t.cssVarBlockName("disabled-text-color")]=e.dark?D(l,50):l.tint(50).toString(),n[t.cssVarBlockName("disabled-border-color")]=e.dark?D(l,80):l.tint(80).toString());else{const s=e.dark?D(l,30):l.tint(30).toString(),f=l.isDark()?`var(${t.cssVarName("color-white")})`:`var(${t.cssVarName("color-black")})`;if(n=t.cssVarBlock({"bg-color":i,"text-color":f,"border-color":i,"hover-bg-color":s,"hover-text-color":f,"hover-border-color":s,"active-bg-color":c,"active-border-color":c}),a.value){const m=e.dark?D(l,50):l.tint(50).toString();n[t.cssVarBlockName("disabled-bg-color")]=m,n[t.cssVarBlockName("disabled-text-color")]=e.dark?"rgba(255, 255, 255, 0.5)":`var(${t.cssVarName("color-white")})`,n[t.cssVarBlockName("disabled-border-color")]=m}}}return n})}const vo=["aria-disabled","disabled","autofocus","type"],yo={name:"ElButton"},go=U({...yo,props:se,emits:mo,setup(e, {expose:a,emit:t}){const n=e,i=de();te({from:"type.text",replacement:"link",version:"3.0.0",scope:"props",ref:"https://element-plus.org/en-US/component/button.html#button-attributes"},B(()=>n.type==="text"));const l=J(ge,void 0),c=fe("button"),s=R("button"),{form:f}=no(),m=lo(B(()=>l==null?void 0:l.size)),p=ve(),y=N(),u=B(()=>n.type||(l==null?void 0:l.type)||""),v=B(()=>{var r,g,k;return(k=(g=n.autoInsertSpace)!=null?g:(r=c.value)==null?void 0:r.autoInsertSpace)!=null?k:!1}),E=B(()=>{var r;const g=(r=i.default)==null?void 0:r.call(i);if(v.value&&(g==null?void 0:g.length)===1){const k=g[0];if((k==null?void 0:k.type)===Fe){const M=k.children;return/^\p{Unified_Ideograph}{2}$/u.test(M.trim())}}return!1}),z=po(n),A= r=>{n.nativeType==="reset"&&(f==null||f.resetFields()),t("click",r)};return a({ref:y,size:m,type:u,disabled:p,shouldAddSpace:E}),(r, g)=>(b(),V("button",{ref_key:"_ref",ref:y,class:C([o(s).b(),o(s).m(o(u)),o(s).m(o(m)),o(s).is("disabled",o(p)),o(s).is("loading",r.loading),o(s).is("plain",r.plain),o(s).is("round",r.round),o(s).is("circle",r.circle),o(s).is("text",r.text),o(s).is("link",r.link),o(s).is("has-bg",r.bg)]),"aria-disabled":o(p)||r.loading,disabled:o(p)||r.loading,autofocus:r.autofocus,type:r.nativeType,style:ne(o(z)),onClick:A},[r.loading?(b(),V(Oe,{key:0},[r.$slots.loading?h(r.$slots,"loading",{key:0}):(b(),P(o(ee),{key:1,class:C(o(s).is("loading"))},{default:T(()=>[(b(),P(Q(r.loadingIcon)))]),_:1},8,["class"]))],64)):r.icon||r.$slots.icon?(b(),P(o(ee),{key:1},{default:T(()=>[r.icon?(b(),P(Q(r.icon),{key:0})):h(r.$slots,"icon",{key:1})]),_:3})):_("v-if",!0),r.$slots.default?(b(),V("span",{key:2,class:C({[o(s).em("text","expand")]:o(E)})},[h(r.$slots,"default")],2)):_("v-if",!0)],14,vo))}});var bo=j(go,[["__file","/home/runner/work/element-plus/element-plus/packages/components/button/src/button.vue"]]);const ho={size:se.size,type:se.type},ko={name:"ElButtonGroup"},Co=U({...ko,props:ho,setup(e){const a=e;me(ge,Pe({size:ae(a,"size"),type:ae(a,"type")}));const t=R("button");return(n, i)=>(b(),V("div",{class:C(`${o(t).b("group")}`)},[h(n.$slots,"default")],2))}});var ke=j(Co,[["__file","/home/runner/work/element-plus/element-plus/packages/components/button/src/button-group.vue"]]);const _o=pe(bo,{ButtonGroup:ke});Ve(ke);const Bo=W({mask:{type:Boolean,default:!0},customMaskEvent:{type:Boolean,default:!1},overlayClass:{type:oe([String,Array,Object])},zIndex:{type:oe([String,Number])}}),So={click: e=>e instanceof MouseEvent};var wo=U({name:"ElOverlay",props:Bo,emits:So,setup(e, {slots:a,emit:t}){const n=R("overlay"),i= f=>{t("click",f)},{onClick:l,onMousedown:c,onMouseup:s}=he(e.customMaskEvent?void 0:i);return()=>e.mask?Y("div",{class:[n.b(),e.overlayClass],style:{zIndex:e.zIndex},onClick:l,onMousedown:c,onMouseup:s},[h(a,"default")],q.STYLE|q.CLASS|q.PROPS,["onClick","onMouseup","onMousedown"]):Re("div",{class:e.overlayClass,style:{zIndex:e.zIndex,position:"fixed",top:"0px",right:"0px",bottom:"0px",left:"0px"}},[h(a,"default")])}});const Eo=wo,Ce=W({center:{type:Boolean,default:!1},alignCenter:{type:Boolean,default:!1},closeIcon:{type:Z},customClass:{type:String,default:""},draggable:{type:Boolean,default:!1},fullscreen:{type:Boolean,default:!1},showClose:{type:Boolean,default:!0},title:{type:String,default:""}}),$o={close:()=>!0},Io=["aria-label"],To=["id"],Mo={name:"ElDialogContent"},Do=U({...Mo,props:Ce,emits:$o,setup(e){const a=e,{t}=ao(),{Close:n}=Ge,{dialogRef:i,headerRef:l,bodyId:c,ns:s,style:f}=J(be),{focusTrapRef:m}=J(Ye),p=ro(m,i),y=B(()=>a.draggable);return io(i,l,y),(u, v)=>(b(),V("div",{ref:o(p),class:C([o(s).b(),o(s).is("fullscreen",u.fullscreen),o(s).is("draggable",o(y)),o(s).is("align-center",u.alignCenter),{[o(s).m("center")]:u.center},u.customClass]),style:ne(o(f)),tabindex:"-1",onClick:v[1]||(v[1]=Ue(()=>{},["stop"]))},[H("header",{ref_key:"headerRef",ref:l,class:C(o(s).e("header"))},[h(u.$slots,"header",{},()=>[H("span",{role:"heading",class:C(o(s).e("title"))},_e(u.title),3)]),u.showClose?(b(),V("button",{key:0,"aria-label":o(t)("el.dialog.close"),class:C(o(s).e("headerbtn")),type:"button",onClick:v[0]||(v[0]= E=>u.$emit("close"))},[Y(o(ee),{class:C(o(s).e("close"))},{default:T(()=>[(b(),P(Q(u.closeIcon||o(n))))]),_:1},8,["class"])],10,Io)):_("v-if",!0)],2),H("div",{id:o(c),class:C(o(s).e("body"))},[h(u.$slots,"default")],10,To),u.$slots.footer?(b(),V("footer",{key:0,class:C(o(s).e("footer"))},[h(u.$slots,"footer")],2)):_("v-if",!0)],6))}});var No=j(Do,[["__file","/home/runner/work/element-plus/element-plus/packages/components/dialog/src/dialog-content.vue"]]);const zo=W({...Ce,appendToBody:{type:Boolean,default:!1},beforeClose:{type:oe(Function)},destroyOnClose:{type:Boolean,default:!1},closeOnClickModal:{type:Boolean,default:!0},closeOnPressEscape:{type:Boolean,default:!0},lockScroll:{type:Boolean,default:!0},modal:{type:Boolean,default:!0},openDelay:{type:Number,default:0},closeDelay:{type:Number,default:0},top:{type:String},modelValue:{type:Boolean,default:!1},modalClass:String,width:{type:[String,Number]},zIndex:{type:Number},trapFocus:{type:Boolean,default:!1}}),Ao={open:()=>!0,opened:()=>!0,close:()=>!0,closed:()=>!0,[ye]: e=>He(e),openAutoFocus:()=>!0,closeAutoFocus:()=>!0},Lo=(e, a)=>{const n=Xe().emit,{nextZIndex:i}=We();let l="";const c=re(),s=re(),f=N(!1),m=N(!1),p=N(!1),y=N(e.zIndex||i());let u,v;const E=fe("namespace",je),z=B(()=>{const I={},G=`--${E.value}-dialog`;return e.fullscreen||(e.top&&(I[`${G}-margin-top`]=e.top),e.width&&(I[`${G}-width`]=x(e.width))),I}),A=B(()=>e.alignCenter?{display:"flex"}:{});function r(){n("opened")}function g(){n("closed"),n(ye,!1),e.destroyOnClose&&(p.value=!1)}function k(){n("close")}function M(){v==null||v(),u==null||u(),e.openDelay&&e.openDelay>0?{stop:u}=ie(()=>O(),e.openDelay):O()}function L(){u==null||u(),v==null||v(),e.closeDelay&&e.closeDelay>0?{stop:v}=ie(()=>d(),e.closeDelay):d()}function F(){function I(G){G||(m.value=!0,f.value=!1)}e.beforeClose?e.beforeClose(I):L()}function S(){e.closeOnClickModal&&F()}function O(){!ue||(f.value=!0)}function d(){f.value=!1}function w(){n("openAutoFocus")}function $(){n("closeAutoFocus")}e.lockScroll&&co(f);function Be(){e.closeOnPressEscape&&F()}return X(()=>e.modelValue, I=>{I?(m.value=!1,M(),p.value=!0,y.value=e.zIndex?y.value++:i(),Ke(()=>{n("open"),a.value&&(a.value.scrollTop=0)})):f.value&&L()}),X(()=>e.fullscreen, I=>{!a.value||(I?(l=a.value.style.transform,a.value.style.transform=""):a.value.style.transform=l)}),ce(()=>{e.modelValue&&(f.value=!0,p.value=!0,M())}),{afterEnter:r,afterLeave:g,beforeLeave:k,handleClose:F,onModalClick:S,close:L,doClose:d,onOpenAutoFocus:w,onCloseAutoFocus:$,onCloseRequested:Be,titleId:c,bodyId:s,closed:m,style:z,overlayDialogStyle:A,rendered:p,visible:f,zIndex:y}},Fo=["aria-label","aria-labelledby","aria-describedby"],Oo={name:"ElDialog",inheritAttrs:!1},Po=U({...Oo,props:zo,emits:Ao,setup(e, {expose:a}){const t=e,n=de();te({scope:"el-dialog",from:"the title slot",replacement:"the header slot",version:"3.0.0",ref:"https://element-plus.org/en-US/component/dialog.html#slots"},B(()=>!!n.title)),te({scope:"el-dialog",from:"custom-class",replacement:"class",version:"2.3.0",ref:"https://element-plus.org/en-US/component/dialog.html#attributes",type:"Attribute"},B(()=>!!t.customClass));const i=R("dialog"),l=N(),c=N(),s=N(),{visible:f,titleId:m,bodyId:p,style:y,overlayDialogStyle:u,rendered:v,zIndex:E,afterEnter:z,afterLeave:A,beforeLeave:r,handleClose:g,onModalClick:k,onOpenAutoFocus:M,onCloseAutoFocus:L,onCloseRequested:F}=Lo(t,l);me(be,{dialogRef:l,headerRef:c,bodyId:p,ns:i,rendered:v,style:y});const S=he(k),O=B(()=>t.draggable&&!t.fullscreen);return a({visible:f,dialogContentRef:s}),(d, w)=>(b(),P(oo,{to:"body",disabled:!d.appendToBody},[Y(eo,{name:"dialog-fade",onAfterEnter:o(z),onAfterLeave:o(A),onBeforeLeave:o(r),persisted:""},{default:T(()=>[qe(Y(o(Eo),{"custom-mask-event":"",mask:d.modal,"overlay-class":d.modalClass,"z-index":o(E)},{default:T(()=>[H("div",{role:"dialog","aria-modal":"true","aria-label":d.title||void 0,"aria-labelledby":d.title?void 0:o(m),"aria-describedby":o(p),class:C(`${o(i).namespace.value}-overlay-dialog`),style:ne(o(u)),onClick:w[0]||(w[0]=(...$)=>o(S).onClick&&o(S).onClick(...$)),onMousedown:w[1]||(w[1]=(...$)=>o(S).onMousedown&&o(S).onMousedown(...$)),onMouseup:w[2]||(w[2]=(...$)=>o(S).onMouseup&&o(S).onMouseup(...$))},[Y(o(Ze),{loop:"",trapped:o(f),"focus-start-el":"container",onFocusAfterTrapped:o(M),onFocusAfterReleased:o(L),onReleaseRequested:o(F)},{default:T(()=>[o(v)?(b(),P(No,Je({key:0,ref_key:"dialogContentRef",ref:s},d.$attrs,{"custom-class":d.customClass,center:d.center,"align-center":d.alignCenter,"close-icon":d.closeIcon,draggable:o(O),fullscreen:d.fullscreen,"show-close":d.showClose,title:d.title,onClose:o(g)}),Qe({header:T(()=>[d.$slots.title?h(d.$slots,"title",{key:1}):h(d.$slots,"header",{key:0,close:o(g),titleId:o(m),titleClass:o(i).e("title")})]),default:T(()=>[h(d.$slots,"default")]),_:2},[d.$slots.footer?{name:"footer",fn:T(()=>[h(d.$slots,"footer")])}:void 0]),1040,["custom-class","center","align-center","close-icon","draggable","fullscreen","show-close","title","onClose"])):_("v-if",!0)]),_:3},8,["trapped","onFocusAfterTrapped","onFocusAfterReleased","onReleaseRequested"])],46,Fo)]),_:3},8,["mask","overlay-class","z-index"]),[[xe,o(f)]])]),_:3},8,["onAfterEnter","onAfterLeave","onBeforeLeave"])],8,["disabled"]))}});var Vo=j(Po,[["__file","/home/runner/work/element-plus/element-plus/packages/components/dialog/src/dialog.vue"]]);const Uo=pe(Vo);export{_o as E,Uo as a};
