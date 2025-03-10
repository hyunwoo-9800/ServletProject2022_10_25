package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ハンドラインターフェース
public interface CommandHandler
{
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception;
}//　CommandHandler　interface
