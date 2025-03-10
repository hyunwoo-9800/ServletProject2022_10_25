package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

// ログアウトを制御するハンドラ
// CommandHandlerインターフェースを具現
public class LogoutHandler implements CommandHandler
{

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    HttpSession session = req.getSession(false);
    if (session != null)
    {
      session.invalidate();
    }

    res.sendRedirect(req.getContextPath());
    return null;
  }

}
