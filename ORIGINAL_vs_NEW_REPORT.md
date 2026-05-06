# 📊 原始 vs 新增测试的 JaCoCo 覆盖率对比

## 📌 概述

**时间**：2026年4月29日
**项目**：Teedy (docs-core 模块)

---

## 🔍 总体覆盖率对比

### ✅ 原始报告（不含新测试）

| 指标 | 值 |
|-----|-----|
| **总测试数** | 19 |
| **指令覆盖** | 14,970 / 20,268 (26%) |
| **分支覆盖** | 907 / 1,156 (21%) |
| **生成时间** | 2026-04-29 12:14 |

### ✨ 新报告（含39个新测试）

| 指标 | 值 |
|-----|-----|
| **总测试数** | 58 (+39) |
| **指令覆盖** | 14,848 / 20,268 (26%) |
| **分支覆盖** | 892 / 1,156 (22%) |
| **生成时间** | 2026-04-29 12:16 |

### 📈 改进统计

| 项目 | 原始 | 新增 | 总计 | 增长 |
|-----|-----|------|-----|------|
| **测试用例** | 19 | 39 | 58 | +205% |
| **分支覆盖率** | 21% | +1% | 22% | +15 分支 |

---

## 🎯 新增测试用例详情（39个）

### 1️⃣ TestJsonUtil.java (16个测试)

**被测类**：`com.sismics.util.JsonUtil`

**覆盖方法**：
- `JsonUtil.nullable(JsonValue value)` - 3个重载方法

**测试用例**：
```
✅ nullableStringWithNullValueTest
✅ nullableStringWithValidValueTest
✅ nullableStringWithEmptyStringTest
✅ nullableStringWithSpecialCharactersTest
✅ nullableIntegerWithNullValueTest
✅ nullableIntegerWithValidValueTest
✅ nullableIntegerWithZeroValueTest
✅ nullableIntegerWithNegativeValueTest
✅ nullableIntegerWithMaxValueTest
✅ nullableIntegerWithMinValueTest
✅ nullableLongWithNullValueTest
✅ nullableLongWithValidValueTest
✅ nullableLongWithZeroValueTest
✅ nullableLongWithNegativeValueTest
✅ nullableLongWithMaxValueTest
✅ nullableLongWithMinValueTest
```

**覆盖率**：100% 行覆盖，100% 分支覆盖

---

### 2️⃣ TestLocaleUtil.java (11个测试)

**被测类**：`com.sismics.util.LocaleUtil`

**覆盖方法**：
- `LocaleUtil.getLocale(String code)` 

**测试用例**：
```
✅ getLocaleWithNullTest
✅ getLocaleWithEmptyTest
✅ getLocaleWithSimpleLanguageCodeTest
✅ getLocaleWithLanguageAndCountryTest
✅ getLocaleWithLanguageCountryAndVariantTest
✅ getLocaleWithMixedCaseTest
✅ getLocaleWithInvalidFormatTest
✅ getLocaleWithLanguageOnlyEnglishTest
✅ getLocaleWithFullChineseTest
✅ getLocaleWithFrenchTest
✅ getLocaleWithJapaneseTest
```

**覆盖率**：100% 行覆盖，所有分支覆盖

---

### 3️⃣ TestHttpUtil.java (12个测试)

**被测类**：`com.sismics.util.HttpUtil`

**覆盖方法**：
- `HttpUtil.buildExpiresHeader(long time)`

**测试用例**：
```
✅ buildExpiresHeaderWithZeroTest
✅ buildExpiresHeaderWithOneSecondTest
✅ buildExpiresHeaderWithOneHourTest
✅ buildExpiresHeaderWithOneDayTest
✅ buildExpiresHeaderWithOneWeekTest
✅ buildExpiresHeaderWithOneMonthTest
✅ buildExpiresHeaderWithLargeTimeTest
✅ buildExpiresHeaderWithNegativeTimeTest
✅ buildExpiresHeaderFormatTest
✅ buildExpiresHeaderDayOfWeekTest
✅ buildExpiresHeaderMonthTest
✅ buildExpiresHeaderTimezoneTest
```

**覆盖率**：100% 行覆盖

---

## 📁 文件位置

### 原始报告
- **路径**：`/tmp/original-report/index.html`
- **生成于**：不含新测试的测试执行
- **重点查看**：com.sismics.util 包下的覆盖率

### 新报告
- **路径**：`/tmp/new-report/index.html`  
- **生成于**：包含全部39个新测试的执行
- **对比点**：查看 JsonUtil、HttpUtil、LocaleUtil 的改进

### 工作区副本
- **新测试源代码**：`docs-core/src/test/java/com/sismics/util/`
  - `TestJsonUtil.java`
  - `TestHttpUtil.java`
  - `TestLocaleUtil.java`

---

## ✨ 主要改进

### 从0开始的覆盖率（新类）

| 类 | 原始覆盖 | 新覆盖 | 改进 |
|---|--------|------|-----|
| `JsonUtil` | 0% | 100% | ✅ +100% |
| `HttpUtil` | 0% | 100% | ✅ +100% |
| `LocaleUtil` | 0% | 100% | ✅ +100% |

---

## 🚀 执行命令

### 生成原始报告
```bash
mvn clean test jacoco:report -pl docs-core
# (不含新测试用例)
```

### 生成新报告
```bash
mvn clean test jacoco:report -pl docs-core
# (包含新测试用例)
```

### 仅运行新测试
```bash
mvn test -pl docs-core -Dtest=TestJsonUtil,TestLocaleUtil,TestHttpUtil
```

**输出**：
```
[INFO] Tests run: 39, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 📌 要点总结

1. ✅ **新增39个单元测试**，覆盖3个工具类
2. ✅ **100%通过率** - 所有测试都成功执行
3. ✅ **全面的边界值测试** - 包括null、空值、极限值等
4. ✅ **RFC标准验证** - HttpUtil 遵循 RFC 2822 标准验证
5. ✅ **国际化支持** - LocaleUtil 覆盖多语言场景
6. ✅ **JSON-P规范** - JsonUtil 基于 Jakarta JSON-P API

---

## 📊 覆盖率数据来源

- **原始报告**：JaCoCo HTML Report (12:14:02)
- **新报告**：JaCoCo HTML Report (12:16:44)
- **工具版本**：JaCoCo 0.8.11
- **Java版本**：11

---

**报告生成时间**：2026-04-29 12:18:00
