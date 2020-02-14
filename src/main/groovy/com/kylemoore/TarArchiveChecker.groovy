package com.kylemoore

import org.apache.commons.compress.archivers.tar.TarArchiveEntry
import org.apache.commons.vfs2.FileObject
import org.apache.commons.vfs2.FileSystemManager
import org.apache.commons.vfs2.FileType
import org.apache.commons.vfs2.VFS
import org.apache.commons.vfs2.provider.tar.TarFileObject


/**
 * Created by kmoore on 2020-02-13.
 */
class TarArchiveChecker {

    static void main(String[] args) {
        TarArchiveEntry entry = null
        entry.getLastModifiedDate()
        entry.getMode()




        VFS.getManager().withCloseable { FileSystemManager fsManager ->
            String[] schemes = fsManager.getSchemes()
            File tarFile = new File('/Users/kmoore/dev/DPUkyle/gradle-copyspec/inner.tar')
            assert tarFile.exists()
            String tarUri = 'tar:file:/Users/kmoore/dev/DPUkyle/gradle-copyspec/inner.tar!/'
            FileObject tarFileObj = fsManager.resolveFile(tarUri)
            println tarFileObj.getChildren()
            tarFileObj.each {
                if (it.isFile()) {
                    println "File:\t$it"
                    def content = it.getContent()
                    def attr = content.getAttributes()
                    def ts = content.getLastModifiedTime()
                    FileType type = it.getType()
                    def perms = it.isExecutable()
                    println ((it as TarFileObject).getContent().getAttributes())
                }
                if (it.isFolder()) {
                    println "Folder:\t$it"
                }
            }
            println 'hello world'
        }

    }
}
