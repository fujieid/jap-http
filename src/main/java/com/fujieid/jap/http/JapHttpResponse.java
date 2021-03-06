package com.fujieid.jap.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @since 1.0.5
 */
public interface JapHttpResponse {

    /**
     * Get the actual source object
     *
     * @return Object
     */
    Object getSource();

    /**
     * Delete cookie
     *
     * @param name cookie name
     * @return current response
     */
    JapHttpResponse delCookie(String name);

    /**
     * Add cookie
     *
     * @param name       name of the cookie.
     * @param value      value of this Cookie.
     * @param path       the path on the server to which the browser returns this cookie.
     * @param domain     domain name of this Cookie.
     * @param expiry     maximum age in seconds of this Cookie.
     * @param secure     send cookies only over a secure protocol, such as HTTPS or SSL.
     * @param isHttpOnly http only.
     * @return current response
     */
    JapHttpResponse addCookie(String name, String value, String path, String domain, int expiry, boolean secure, boolean isHttpOnly);

    /**
     * Add cookie
     *
     * @param cookie JapHttpCookie
     * @return current response
     */
    default JapHttpResponse addCookie(JapHttpCookie cookie) {
        if (null == cookie) {
            return this.addCookie(null, null, null, null, 0, false, false);
        }
        return this.addCookie(cookie.getName(), cookie.getValue(), cookie.getPath(), cookie.getDomain(),
            cookie.getMaxAge(), cookie.isSecure(), cookie.isHttpOnly()
        );
    }

    /**
     * Set response status code
     *
     * @param status Response status code
     * @return current response
     */
    JapHttpResponse setStatus(int status);

    /**
     * Add response header
     *
     * @param name  name of the response header
     * @param value value of the response header
     * @return current response
     */
    JapHttpResponse addHeader(String name, String value);

    /**
     * Sets the content type of the response being sent to the client, if the response has not been committed yet. The
     * given content type may include a character encoding specification, for example,
     * <code>text/html;charset=UTF-8</code>. The response's character encoding is only set from the given content type
     * if this method is called before <code>getWriter</code> is called.
     *
     * @param contentType a <code>String</code> specifying the MIME type of the content
     * @return current response
     */
    JapHttpResponse setContentType(String contentType);

    /**
     * Sets the length of the content body in the response In HTTP servlets, this method sets the HTTP Content-Length
     * header.
     *
     * @param len an integer specifying the length of the content being returned to the client; sets the Content-Length
     *            header
     * @return current response
     */
    JapHttpResponse setContentLength(int len);

    /**
     * Write HTML to the browser or web side
     *
     * @param html content
     */
    void write(String html);

    /**
     * Returns the name of the character encoding (MIME charset) used for the body sent in this response
     * <p>
     * See RFC 2047 (http://www.ietf.org/rfc/rfc2047.txt) for more information about character encoding and MIME.
     *
     * @return a <code>String</code> specifying the name of the character encoding, for example, <code>UTF-8</code>
     */
    String getCharacterEncoding();

    /**
     * Returns a {@link OutputStream} suitable for writing binary data in the response.
     *
     * @return a {@link OutputStream} for writing binary data
     * @throws IOException if an input or output exception occurred
     */
    OutputStream getOutputStream() throws IOException;

    /**
     * Redirect to url
     *
     * @param url Redirect url
     */
    void redirect(String url);
}
