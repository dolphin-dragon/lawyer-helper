package lawyer.base.ccase.plugins.email;

import lawyer.base.ccase.entity.SysUserExt;

public interface MailService {
    //发送邮件
    public boolean sendMail(String to, String title, String content);
    //发送注册激活邮件
    public boolean sendRegisterMailByAsync(SysUserExt user);
    //发送找回密码邮件
    public boolean sendFindPwdMailByAsync(SysUserExt user);
    //发送重置密码邮件
    public boolean sendReSetPwdMailByAsync(SysUserExt user);
}