## Tell me about yourself

```
I am happy to introduce myself. My name is Liu Yan, Twenty-six years old. 
I graduated from Lanzhou University with a master's degree in computer science, 
and from Zhengzhou University with a bachelor's degree in software engineering, 
and also with a certificate in English level six.

I have two years of experience in software development. 
When I was at BYD, in addition to Java and Spring development, I also served as a front-end developer and DevOps pipeline operation and maintenance. 
My code submission volume is the first in the team. I have submitted 900 codes to gitee in the past 9 months. 
It is worth mentioning that I have participated in the release and guarantee work of the LES system before its launch many times at night.

I am known for my problem-solving skills and ability to work with cross-functional teams. 
I am very good at dealing with functional colleagues, product colleagues, implementation consultants, and even customers.

Outside of work, I am keen to volunteer for open source projects such as GitHub, JetBrains' official plugin OpenFeignX, where I mentor aspiring developers and realize my value.

that`s all. thank you !
```
## why hsbc
```
#首先，汇丰作为全球领先的国际金融服务机构之一
First, as one of the world's leading international financial services institutions, 
#致力于推动可持续发展，这一点与我个人的价值观非常吻合
HSBC is committed to promoting sustainable development, which is very consistent with my personal values. 
#我支持公司在绿色金融、社会责任，以及投资等方面的举措
I support the company's initiatives in green finance, social responsibility, and investment.

# 其次，对比其他的银行，汇丰十分注重创新和技术。我相信汇丰在金融科技领域的投入不仅会带来业务上的增长，也能为客户创造更多的价值。
Second, compared with other banks, HSBC pays great attention to innovation and technology. 
I believe that HSBC's investment in financial technology will not only bring business growth, but also create more value for customers.

# 因此，我希望可以参与到这样充满活力和前瞻性的项目中，利用我的技能帮助公司实现其战略目标。
Therefore, I hope to be able to participate in such a dynamic and forward-looking project and use my skills to help the company achieve its strategic goals.
```
## Why should we hire you
```
You should hire me because I have a unique combination of technical expertise and a excellent performance.

During my tenure at BYD, I not only contributed the most code commits and code volume, but also led the team to complete the automated logistics project ahead of schedule, saving the company 20% of operating costs.

My ability to collaborate effectively and continuously learning makes me a valuable asset to any team.
```
## What's your greatest strength
```
# 适应能力：我在多变的工作环境中茁壮成长，并一直表现出快速学习新技术的能力。
Adapt ability, I thrive in dynamic work environments and have consistently demonstrated the ability to learn new technologies quickly. 
# 保持自信心的能力，同时乐观，因此抗压
keep self-confidence ability, and be optimistic, thus I have the ability of anti-pressure
```
## What's your greatest weakness
```
I used to struggle with delegating tasks, often taking on too much myself. 

However, I recognized this as a weakness and actively worked on improving my delegation skills. 

I now understand the importance of empowering team members and have seen how it enhances both productivity and team morale." 
```
##  Can you describe a challenging situation you faced at work and how you handled it
```
Certainly. In my previous role, we faced a tight deadline to complete a project with a high degree of complexity. It is about the generic parsing problem in event publishing

The team was under immense pressure, and conflicts started to arise. 

I took the initiative to organize a team meeting, where we openly discussed our concerns and brainstormed solutions. 

By fostering open communication and Study the official spring documentation about generics in event publishing

we not only met the deadline but also improved my personal influence in the team
```
## design pattern

### duty chain pattern 
LoginUser
```java
public class LoginUser {
    private String loginName;
    private String password;
    private String roleName;
    private String permission;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
```
AbstractHandler
```java

public abstract class AbstractHandler {
    private AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler handler){
        this.nextHandler = handler;
    }
    public AbstractHandler getNextHandler(){
        return this.nextHandler;
    }
    public boolean hasNext(){
        return nextHandler != null;
    }
    public boolean handle(LoginUser loginUser){
        if (hasNext()){
            return getNextHandler().doHandler(loginUser);
        }
        return false;
    }
    /**
     * 子类实现
     * @param loginUser
     * @return
     */
    protected abstract boolean doHandler(LoginUser loginUser);

}
```
VerifyAccountHandler
```java
public class VerifyAccountHandler extends AbstractHandler {
    @Override
    public boolean doHandler(LoginUser loginUser) {
        if (StringUtils.isBlank(loginUser.getLoginName())){
            System.out.println("用户名不能为空");
            return false;
        }
        if (StringUtils.isBlank(loginUser.getPassword())){
            System.out.println("密码不能为空");
            return false;
        }
        if (!loginUser.getPassword().equals("123456")){
            System.out.println("密码不正确");
            return false;
        }
        System.out.println("1.账号密码校验通过");

        return super.handle(loginUser);
    }
}
```
VerifyRoleHanlder
```java
public class VerifyRoleHanlder extends AbstractHandler {
    @Override
    public boolean doHandler(LoginUser loginUser) {
        if(!"admin".equals(loginUser.getRoleName())){
            System.out.println("角色信息有误");
            return false;
        }
        System.out.println("2.角色信息校验通过");

        return super.handle(loginUser);
    }
}
```
VerifyPermissionHanlder
```java
public class VerifyPermissionHanlder extends AbstractHandler {
    @Override
    public boolean doHandler(LoginUser loginUser) {
        if (!"admin".equals(loginUser.getPermission())){
            System.out.println("暂无权限");
            return false;
        }
        System.out.println("3.权限校验通过，登录成功");

        return super.handle(loginUser);
    }
}
```
ChainBuilder
```java
public class ChainBuilder {
    private AbstractHandler head;
    private AbstractHandler tail;
    
    public ChainBuilder addHandler(AbstractHandler handler){
        if (head==null){
            head = tail = handler;
            return this;
        }
        tail.setNextHandler(handler);
        tail = handler;
    }
    
    public AbstractHandler build(){
        return this.head;
    }
    
}
```
TestBuildChain, 由第一个handler的doHandler触发整个联调
```java
public class TestBuildChain {
    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");

        ChainBuilder chainBuilder = new ChainBuilder();
        chainBuilder.addHanlder(new VerifyAccountHandler())
                .addHanlder(new VerifyRoleHanlder())
                .addHanlder(new VerifyPermissionHanlder());
        chainBuilder.build().doHandler(loginUser);
    }
}
```

