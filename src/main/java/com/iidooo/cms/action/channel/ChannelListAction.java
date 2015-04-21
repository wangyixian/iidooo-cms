package com.iidooo.cms.action.channel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.co.sot.vote.entity.message.Article;
import cn.co.sot.vote.entity.message.MPNewsMessage;
import cn.co.sot.vote.entity.message.TextMessage;
import cn.co.sot.vote.entity.message.news.NewsArticle;
import cn.co.sot.vote.entity.message.news.NewsMessage;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.channel.IChannelListService;
import com.iidooo.core.dto.PageDto;
import com.opensymphony.xwork2.ActionSupport;

public class ChannelListAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelListAction.class);

    @Autowired
    private IChannelListService channelListService;

    private List<ChannelDto> channelList;

    private ChannelDto channel;
    
    private PageDto page;

    public List<ChannelDto> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelDto> channelList) {
        this.channelList = channelList;
    }

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public PageDto getPage() {
        return page;
    }

    public void setPage(PageDto page) {
        this.page = page;
    }

    public String init() {
        try {
            if (channel == null) {
                // Default is get the root channel list.
                channelList = channelListService.getChildrenChannelList(0);
            } else {
                // Get the current channel's children channel list
                channelList = channelListService.getChildrenChannelList(channel.getChannelID());
            }
            
            for (ChannelDto item : channelList) {
                
            }
            
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

    public String delete() {
        try {
            List<ChannelDto> children = channelListService.getChildrenChannelList(this.channel.getChannelID());
            if (children != null && children.size() > 0) {
                addActionError(getText("MSG_CHANNEL_DELETE_FAILED_CHILDREN", this.channel.getChannelName()));
                return INPUT;
            } else if (!channelListService.deleteChannel(this.channel)) {
                addActionError(getText("MSG_CHANNEL_DELETE_FAILED", this.channel.getChannelName()));
                return INPUT;
            }
            channelList = channelListService.getChildrenChannelList(channel.getParentID());
            
            addActionMessage(getText("MSG_CHANNEL_DELETE_SUCCESS", this.channel.getChannelName()));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
    
    public String setUserName() throws Exception {

        String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token={0}";
        url = url.replace("{0}", ACCESS_TOKEN);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {

            String jsonObjectStr = "";

            switch (msgType) {
            case "text":
                TextMessage textMessage = new TextMessage();
                textMessage.setTouser(toUser);
                textMessage.setMsgtype(msgType);
                textMessage.setAgentid(1);
                textMessage.setContent(description);

                jsonObjectStr = textMessage.toJSONString();
                break;
            case "mpnews":
                MPNewsMessage message = new MPNewsMessage();
                message.setTouser(toUser);
                message.setMsgtype(msgType);
                message.setAgentid(1);

                List<Article> articles = new ArrayList<Article>();
                Article article = new Article();
                article.setTitle("测试提交按钮的javascript");
                article.setThumb_media_id("2jZiOVRZjCGjXAi6tv9x-Io94FuPa8JILVegIg3o7xX89RARJsqVuutmfL9fAPBge");
                article.setContent_source_url("http://www.sot-soft.com:8080/vote/NewFile.html");
                article.setContent(getContent());
                article.setShow_cover_pic("1");
                articles.add(article);

                message.setArticles(articles);

                // JSONObject jsonObject = new JSONObject();
                // jsonObject.element("touser", "@all");
                // //jsonObject.element("msgtype", "text");
                // jsonObject.element("msgtype", "mpnews");
                // jsonObject.element("agentid", 1);

                // JSONObject jsonObjectText = new JSONObject();
                // jsonObjectText.element("content", "这是来自企业应用《年会投票》的消息，测试中文！");
                // jsonObject.element("text", jsonObjectText);

                // JSONObject jsonObjectMPnews = new JSONObject();
                //
                // JSONArray jsonObjectArticles = new JSONArray();

                // JSONObject article = new JSONObject();
                // article.element("title", "年会投票");

                // jsonObjectArticles

                // jsonObjectMPnews.element("articles", jsonObjectArticles);
                // jsonObject.element("mpnews", jsonObjectMPnews);

                jsonObjectStr = message.toJSONString();

                break;
            case "news":
                NewsMessage newsMessage = new NewsMessage();

                newsMessage.setTouser(toUser);
                newsMessage.setMsgtype(msgType);
                newsMessage.setAgentid(1);

                List<NewsArticle> newsArticles = new ArrayList<NewsArticle>();
                NewsArticle newsArticle = new NewsArticle();
                newsArticle.setTitle(title);
                newsArticle.setDescription(description);
                newsArticle.setUrl(redirectURL);
                newsArticle.setPicurl(picURL);
                newsArticles.add(newsArticle);

                newsMessage.setArticles(newsArticles);

                jsonObjectStr = newsMessage.toJSONString();
                break;
            default:
                break;
            }

            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
            StringEntity stringEntity = new StringEntity(jsonObjectStr, "UTF-8");
            stringEntity.setContentType("text/json");
            // stringEntity.setContentEncoding(new BasicHeader("CHARSET",
            // "UTF-8"));
            httpPost.setEntity(stringEntity);
            response = httpclient.execute(httpPost);

            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            InputStreamReader inputStreamReader = new InputStreamReader(entity.getContent(), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            StringBuilder httpContent = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                httpContent.append(line + "\n");
            }

            // JSONObject jsonObject =
            // JSONObject.fromObject(httpContent.toString());
            // String accessToken =
            // jsonObject.getString(WeiXinConstants.ACCESS_TOKEN);
            result = httpContent.toString();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
