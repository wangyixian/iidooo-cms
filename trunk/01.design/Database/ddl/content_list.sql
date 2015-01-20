SELECT C.ContentID, C.Title, S.PV FROM IDO_CMS_CONTENT C 
inner join IDO_CMS_CHANNEL L on C.ChannelID = L.ChannelID and L.ChannelPath = "comic" and L.IsDelete = 0 and C.IsDelete = 0
inner join 
(SELECT ContentID FROM ido_cms_content_tag T where T.ClassCode = "TAG_COMIC_STATUS" and T.ItemCode = "1" and T.IsDelete = 0) T 
left outer join 
(SELECT count(*) PV, TableDataID FROM IDO_CMS_STATISTICS S where s.TableName = "IDO_CMS_CONTENT" and s.StatisticsType = 1 and S.IsDelete = 0) S
on C.ContentID = T.ContentID and S.TableDataID = C.ContentID order by S.PV desc limit 10
;

