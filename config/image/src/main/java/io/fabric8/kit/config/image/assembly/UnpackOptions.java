// =================== DO NOT EDIT THIS FILE ====================
// Generated by Modello 1.8.3,
// any modifications will be overwritten.
// ==============================================================

package io.fabric8.kit.config.image.assembly;

/**
 *
 *       Specifies options for including/excluding/filtering items
 * extracted from an archive. (Since 2.2)
 *       .
 *
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class UnpackOptions
    implements java.io.Serializable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field includes.
     */
    private java.util.List<String> includes;

    /**
     * Field excludes.
     */
    private java.util.List<String> excludes;

    /**
     *
     *           Whether to filter symbols in the files as they are
     * unpacked from the archive, using
     *           properties from the build configuration. (Since
     * 2.2)
     *           .
     */
    private boolean filtered = false;

    /**
     *
     *
     *             Sets the line-endings of the files. (Since 2.2)
     *             Valid values:
     *             <ul>
     *               <li><b>"keep"</b> - Preserve all line
     * endings</li>
     *               <li><b>"unix"</b> - Use Unix-style line
     * endings</li>
     *               <li><b>"lf"</b> - Use a single line-feed line
     * endings</li>
     *               <li><b>"dos"</b> - Use DOS-style line
     * endings</li>
     *               <li><b>"crlf"</b> - Use Carraige-return,
     * line-feed line endings</li>
     *             </ul>
     *
     *
     */
    private String lineEnding;

    /**
     *
     *             Whether standard exclusion patterns, such as
     * those matching CVS and Subversion
     *             metadata files, should be used when calculating
     * the files affected by this set.
     *             For backward compatibility, the default value is
     * true. (Since 2.2)
     *           .
     */
    private boolean useDefaultExcludes = true;

    /**
     *
     *
     *               Allows to specify the encoding to use when
     * unpacking archives, for unarchivers
     *               that support specifying encoding. If
     * unspecified, archiver default will be used.
     *               Archiver defaults generally represent sane
     * (modern) values.
     *
     *
     */
    private String encoding;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addExclude.
     *
     * @param string
     */
    public void addExclude( String string )
    {
        getExcludes().add( string );
    } //-- void addExclude( String )

    /**
     * Method addInclude.
     *
     * @param string
     */
    public void addInclude( String string )
    {
        getIncludes().add( string );
    } //-- void addInclude( String )

    /**
     * Get allows to specify the encoding to use when unpacking
     * archives, for unarchivers
     *               that support specifying encoding. If
     * unspecified, archiver default will be used.
     *               Archiver defaults generally represent sane
     * (modern) values.
     *
     * @return String
     */
    public String getEncoding()
    {
        return this.encoding;
    } //-- String getEncoding()

    /**
     * Method getExcludes.
     *
     * @return List
     */
    public java.util.List<String> getExcludes()
    {
        if ( this.excludes == null )
        {
            this.excludes = new java.util.ArrayList<String>();
        }

        return this.excludes;
    } //-- java.util.List<String> getExcludes()

    /**
     * Method getIncludes.
     *
     * @return List
     */
    public java.util.List<String> getIncludes()
    {
        if ( this.includes == null )
        {
            this.includes = new java.util.ArrayList<String>();
        }

        return this.includes;
    } //-- java.util.List<String> getIncludes()

    /**
     * Get sets the line-endings of the files. (Since 2.2)
     *             Valid values:
     *             <ul>
     *               <li><b>"keep"</b> - Preserve all line
     * endings</li>
     *               <li><b>"unix"</b> - Use Unix-style line
     * endings</li>
     *               <li><b>"lf"</b> - Use a single line-feed line
     * endings</li>
     *               <li><b>"dos"</b> - Use DOS-style line
     * endings</li>
     *               <li><b>"crlf"</b> - Use Carraige-return,
     * line-feed line endings</li>
     *             </ul>
     *
     * @return String
     */
    public String getLineEnding()
    {
        return this.lineEnding;
    } //-- String getLineEnding()

    /**
     * Get whether to filter symbols in the files as they are
     * unpacked from the archive, using
     *           properties from the build configuration. (Since
     * 2.2).
     *
     * @return boolean
     */
    public boolean isFiltered()
    {
        return this.filtered;
    } //-- boolean isFiltered()

    /**
     * Get whether standard exclusion patterns, such as those
     * matching CVS and Subversion
     *             metadata files, should be used when calculating
     * the files affected by this set.
     *             For backward compatibility, the default value is
     * true. (Since 2.2).
     *
     * @return boolean
     */
    public boolean isUseDefaultExcludes()
    {
        return this.useDefaultExcludes;
    } //-- boolean isUseDefaultExcludes()

    /**
     * Method removeExclude.
     *
     * @param string
     */
    public void removeExclude( String string )
    {
        getExcludes().remove( string );
    } //-- void removeExclude( String )

    /**
     * Method removeInclude.
     *
     * @param string
     */
    public void removeInclude( String string )
    {
        getIncludes().remove( string );
    } //-- void removeInclude( String )

    /**
     * Set allows to specify the encoding to use when unpacking
     * archives, for unarchivers
     *               that support specifying encoding. If
     * unspecified, archiver default will be used.
     *               Archiver defaults generally represent sane
     * (modern) values.
     *
     * @param encoding
     */
    public void setEncoding( String encoding )
    {
        this.encoding = encoding;
    } //-- void setEncoding( String )

    /**
     * Set set of file and/or directory patterns for matching items
     * to be excluded from an archive as it is unpacked.
     *             Each item is specified as
     * &lt;exclude&gt;some/path&lt;/exclude&gt; (Since 2.2).
     *
     * @param excludes
     */
    public void setExcludes( java.util.List<String> excludes )
    {
        this.excludes = excludes;
    } //-- void setExcludes( java.util.List )

    /**
     * Set whether to filter symbols in the files as they are
     * unpacked from the archive, using
     *           properties from the build configuration. (Since
     * 2.2).
     *
     * @param filtered
     */
    public void setFiltered( boolean filtered )
    {
        this.filtered = filtered;
    } //-- void setFiltered( boolean )

    /**
     * Set set of file and/or directory patterns for matching items
     * to be included from an archive as it is unpacked.
     *             Each item is specified as
     * &lt;include&gt;some/path&lt;/include&gt; (Since 2.2).
     *
     * @param includes
     */
    public void setIncludes( java.util.List<String> includes )
    {
        this.includes = includes;
    } //-- void setIncludes( java.util.List )

    /**
     * Set sets the line-endings of the files. (Since 2.2)
     *             Valid values:
     *             <ul>
     *               <li><b>"keep"</b> - Preserve all line
     * endings</li>
     *               <li><b>"unix"</b> - Use Unix-style line
     * endings</li>
     *               <li><b>"lf"</b> - Use a single line-feed line
     * endings</li>
     *               <li><b>"dos"</b> - Use DOS-style line
     * endings</li>
     *               <li><b>"crlf"</b> - Use Carraige-return,
     * line-feed line endings</li>
     *             </ul>
     *
     * @param lineEnding
     */
    public void setLineEnding( String lineEnding )
    {
        this.lineEnding = lineEnding;
    } //-- void setLineEnding( String )

    /**
     * Set whether standard exclusion patterns, such as those
     * matching CVS and Subversion
     *             metadata files, should be used when calculating
     * the files affected by this set.
     *             For backward compatibility, the default value is
     * true. (Since 2.2).
     *
     * @param useDefaultExcludes
     */
    public void setUseDefaultExcludes( boolean useDefaultExcludes )
    {
        this.useDefaultExcludes = useDefaultExcludes;
    } //-- void setUseDefaultExcludes( boolean )

}