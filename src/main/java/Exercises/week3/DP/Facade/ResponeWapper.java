package Exercises.week3.DP.Facade;

import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class ResponeWapper {
    private final int code;
    private final HttpEntity content;


    public ResponeWapper(int code, HttpEntity content) {
        this.code = code;
        this.content = content;
    }

    public void printResponse() throws IOException, ParseException {
        System.out.println(code);
        String json = EntityUtils.toString(this.content);
        System.out.println(json);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponeWapper{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
