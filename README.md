#消息平台客户端

##相关文档

##简单用法示例

示例代码：

    CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
    //查询全部
    List<Country> countryList = mapper.select(new Country());
    //总数
    Assert.assertEquals(183, countryList.size());

    //通用Example查询
    Example example = new Example(Country.class);
    example.createCriteria().andGreaterThan("id", 100);
    countryList = mapper.selectByExample(example);
    Assert.assertEquals(83, countryList.size());

    //MyBatis-Generator生成的Example查询
    CountryExample example2 = new CountryExample();
    example2.createCriteria().andIdGreaterThan(100);
    countryList = mapper.selectByExample(example2);
    Assert.assertEquals(83, countryList.size());

CountryMapper代码如下：

    public interface CountryMapper extends Mapper<Country> {
    }


##使用Maven

###重要提示

##引入Jar包，下载地址：


## [更新日志](http://www.xxx.com)

### 1.0.0 - 2016-05-28

